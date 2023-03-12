package com.scentdex.controller;

import java.io.IOException;
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
        name = "Explore",
        urlPatterns = {" /learn "}
)
public class Explore extends HttpServlet {
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
        String url = "/learn.jsp";
        // set page title
        request.setAttribute("pageTitle", "Find your next fragrance");
        // get dispatcher
        RequestDispatcher dispatcher = request.getServletContext().getRequestDispatcher(url);
        // forward
        dispatcher.forward(request, response);
    }
}
