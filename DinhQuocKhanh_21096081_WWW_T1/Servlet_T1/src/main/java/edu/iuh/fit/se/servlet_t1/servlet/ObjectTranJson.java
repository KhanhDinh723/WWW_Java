package edu.iuh.fit.se.servlet_t1.servlet;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import com.fasterxml.jackson.databind.ObjectMapper;

import edu.iuh.fit.se.servlet_t1.entities.User;
/**
 * Author: Khánh Đinh
 * Date:   8/28/2025
 * Time:   1:57 PM
 */
//**
//        * Servlet implementation class ObjectTranJson
// */
public class ObjectTranJson<ObjectMapper> extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public ObjectTranJson() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        User u = new User(1, "B", "A");
        ObjectMapper mapper = new ObjectMapper();
        String json = mapper.writeValueAsString(u);
        response.setContentType("application/json");
        response.getWriter().write(json);
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        doGet(request, response);
    }

}
