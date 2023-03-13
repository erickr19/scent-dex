package com.scentdex.controller;

import com.scentdex.entity.Fragrance;
import com.scentdex.persistence.GenericDao;

import java.io.IOException;
import java.util.List;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

/**
 * Explore servlet class.
 * Forwards to the Explore page.
 * Lists all fragrances on a table.
 * @author ereyes3
 */
@WebServlet(
        name = "explore",
        urlPatterns = { "/explore" }
)
public class Explore extends HttpServlet {
    // instance variables
    List fragrances;
    /**
     * doGet
     * Called whenever user visits Explore.
     * Forwards to explore.jsp
     * @exception ServletException if there is a servlet failure
     * @exception IOException if there is an IO error
     */
    public void doGet(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
        // set url
        String url = "/explore.jsp";
        // set page title
        request.setAttribute("pageTitle", "Find your next fragrance");
        // call retrieveFragrances
        retrieveFragrances();
        // set fragrances attribute
        request.setAttribute("retrievedFragrances", fragrances);
        // get dispatcher
        RequestDispatcher dispatcher = request.getServletContext().getRequestDispatcher(url);
        // forward
        dispatcher.forward(request, response);
    }

    public void retrieveFragrances() {
        // instance variables
        GenericDao fragranceDao = new GenericDao(Fragrance.class);
        fragrances = fragranceDao.getAll();
    }
}
