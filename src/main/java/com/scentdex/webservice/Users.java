package com.scentdex.webservice;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import javax.ws.rs.core.Response;
import com.scentdex.persistence.*;
import com.scentdex.entity.User;
import java.util.List;

@Path("/users")
public class Users {
    // instance variables
    List users;
    User user;
    GenericDao userDao = new GenericDao(User.class);
    ObjectWriter objectWriter = new ObjectMapper().writer().withDefaultPrettyPrinter();

    /**
     * Gets all users in Users table.
     * @return Response json of all users in Users table
     * @throws JsonProcessingException if there is an error processing json
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getUsers() throws JsonProcessingException {
        // return all users from getAllUsers()
        getAllUsers();
        String json = objectWriter.writeValueAsString(users);
        return Response.status(200).entity(json).build();
    }

    /**
     * Get user by specified id.
     * @param id The id of the user.
     * @return json of the specified user.
     * @throws JsonProcessingException if there is an error processing json.
     */
    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getUserWithId(@PathParam("id") int id) throws JsonProcessingException {
        getUserById(id);
        String json = objectWriter.writeValueAsString(user);
        return Response.status(200).entity(json).build();
    }

    /**
     * Gets all users
     */
    public void getAllUsers() {
        users = userDao.getAll();
    }

    /**
     * Gets user by specified id
     * @param id
     */
    public void getUserById(int id) {
        user = (User)userDao.getById(id);
    }
}
