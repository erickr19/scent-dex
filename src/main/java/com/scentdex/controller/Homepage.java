package com.scentdex.controller;

import java.io.IOException;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

/**
 * Homepage servlet class.
 * Forwards to the homepage
 * @author ereyes3
 */
@WebServlet(
        name = "homepage",
        urlPatterns = { "/homepage" }
)
public class Homepage extends HttpServlet {
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
        String url = "/index.jsp";
        // get dispatcher
        RequestDispatcher dispatcher = request.getServletContext().getRequestDispatcher(url);
        // forward
        dispatcher.forward(request, response);
    }
}
