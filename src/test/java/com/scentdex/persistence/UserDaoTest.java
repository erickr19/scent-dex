package com.scentdex.persistence;

import com.scentdex.entity.User;
import com.scentdex.testUtils.Database;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * UserDao test
 * @author ereyes3
 */
class UserDaoTest {
    // instance variables
    // declare dao
    GenericDao userDao;
    // declare db
    Database db;
    // declare user list
    List<User> users;
    @BeforeEach
    void setUp() {
        userDao = new GenericDao(User.class);
        db = Database.getInstance();
        db.runSQL("scent-dex-dump.sql");
        users = userDao.getAll();
    }

    /**
     * Tests inserting a new user into the database.
     */
    @Test
    void insert() {
        // create new user
        User newUser = new User();
        // add user data
        newUser.setEmail("bobsmith@example.org");
        newUser.setPassword("bsmtih123");
        newUser.setUsername("smithyb");
        // get new userId
        int newUserId = userDao.insert(newUser);
        // get inserted user
        User insertedUser = (User) userDao.getById(newUserId);
        // assert equals test
        assertEquals(newUser.getUsername(), insertedUser.getUsername());
    }

    /**
     * Tests getting a user by id
     * Tests id 1 as it's constant even when db is refreshed.
     */
    @Test
    void getById() {
        // get user
        User fetchedUser = (User)userDao.getById(1);
        // test username
        assertEquals("erickrey", fetchedUser.getUsername());
    }

    /**
     * Tests updating a user in the database
     * Tests user 1 as it's constant when db is refreshed.
     */
    @Test
    void update() {
        // new username
        String newUsername = "elrey_erick";
        // get user
        User userToUpdate = (User)userDao.getById(1);
        // set new username
        userToUpdate.setUsername(newUsername);
        // call update method
        userDao.update(userToUpdate);
        // get user once again
        User updatedUser = (User)userDao.getById(1);
        // test
        assertEquals(newUsername, updatedUser.getUsername());
    }

    /**
     * Tests deleting a user in the database
     */
    @Test
    void delete() {
        // delete user
        userDao.delete(userDao.getById(1));
        // test
        assertNull(userDao.getById(1));
    }

    /**
     * Tests finding by single property
     */
    @Test
    void findByProperty() {
        // reset user list
        users.clear();
        // get user with property
        users = userDao.findByPropertyEqual("username", "erickrey");
        // test
        assertTrue(users.size() > 0);
        assertTrue(users.get(0).getUsername().equals("erickrey"));
    }

    /**
     * Tests getting all users
     */
    @Test
    void getAll() {
        assertTrue(users.size() > 0);
        assertFalse(users.get(0).getEmail().equals(""));
    }
}