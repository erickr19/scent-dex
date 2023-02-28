package com.scentdex.controller;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Homepage servlet class.
 * Forwards to the learn page
 * @author ereyes3
 */
@WebServlet(
        name = "learn",
        urlPatterns = { "/learn" }
)
public class Learn extends HttpServlet {
    /**
     * doGet method
     * Called when user visits the web app.
     * Forwards user to index.jsp
     * @exception ServletException if there is a servlet failure
     * @exception IOException if there is an IO error.
     */
    public void doGet(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
        // set url
        String url = "/learn.jsp";
        // get dispatcher
        RequestDispatcher dispatcher = request.getServletContext().getRequestDispatcher(url);
        // forward
        dispatcher.forward(request, response);
    }
}
