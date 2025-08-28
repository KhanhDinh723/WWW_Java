package edu.iuh.fit.se.servlet_t1.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Author: Khánh Đinh
 * Date:   8/28/2025
 * Time:   1:51 PM
 */
//**
//        * Servlet implementation class RegistationForm
// */

//@WebServlet("/RegistationForm")
public class RegistationForm extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegistationForm() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        String username = request.getParameter("username");
        String email = request.getParameter("email");
        String facebook = request.getParameter("facebook");
        String shortBio = request.getParameter("shortBio");

        String html = "<html><head><title>Result Page</title></head><body>";
        html += "<h1>Registration Details</h1>";
        html += "<p><strong>First Name:</strong> " + firstName + "</p>";
        html += "<p><strong>Last Name:</strong> " + lastName + "</p>";
        html += "<p><strong>Username:</strong> " + username + "</p>";
        html += "<p><strong>Email:</strong> " + email + "</p>";
        html += "<p><strong>Facebook:</strong> " + facebook + "</p>";
        html += "<p><strong>Short Bio:</strong> " + shortBio + "</p>";
        html += "</body></html>";

        out.println(html);

    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
     *      response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // TODO Auto-generated method stub
        doGet(request, response);
    }

}

