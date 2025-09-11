package edu.iuh.fit.se.Bai1.model;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

/**
 * Author: Khánh Đinh
 * Date:   9/11/2025
 * Time:   3:04 PM
 */
@WebServlet ("/registration-form")
public class RegistrationServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * Default constructor.
     *
     */
    public RegistrationServlet() {
        // TODO Auto-generated constructor stub
        super();



    }

    //    public Student(String firstName, String lastName, LocalDate dateOfBirth, String email, String phoneNumber, String gender, String address, String city, int pinCode, String state, String country, List<String> hobbies, String classXBoard, double classXPercentage, int classXYearOfPassing, String classXIIBoard, double classXIIPercentage, int classXIIYearOfPassing, String graduationBoard, double graduationPercentage, int graduationYearOfPassing, String masterBoard, double masterPercentage, int masterYearOfPassing, String courseAppliedFor) {
//        this.firstName = firstName;
//        this.lastName = lastName;
//        this.dateOfBirth = dateOfBirth;
//        this.email = email;
//        this.phoneNumber = phoneNumber;
//        this.gender = gender;
//        this.address = address;
//        this.city = city;
//        this.pinCode = pinCode;
//        this.state = state;
//        this.country = country;
//        this.hobbies = hobbies;
//        this.classXBoard = classXBoard;
//        this.classXPercentage = classXPercentage;
//        this.classXYearOfPassing = classXYearOfPassing;
//        this.classXIIBoard = classXIIBoard;
//        this.classXIIPercentage = classXIIPercentage;
//        this.classXIIYearOfPassing = classXIIYearOfPassing;
//        this.graduationBoard = graduationBoard;
//        this.graduationPercentage = graduationPercentage;
//        this.graduationYearOfPassing = graduationYearOfPassing;
//        this.masterBoard = masterBoard;
//        this.masterPercentage = masterPercentage;
//        this.masterYearOfPassing = masterYearOfPassing;
//        this.courseAppliedFor = courseAppliedFor;
//    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.getWriter().append("Served at: ").append(request.getContextPath()).append(request.getServletPath());
        //Get data from form

        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        String dateOfBirth = request.getParameter("dateOfBirth");
        String email = request.getParameter("email");
        String phoneNumber = request.getParameter("phoneNumber");
        String gender = request.getParameter("gender");
        String address = request.getParameter("address");
        String city = request.getParameter("city");
        int pinCode = Integer.parseInt(request.getParameter("pinCode"));
        String state = request.getParameter("state");
        String country = request.getParameter("country");
        String[] hobbiesArray = request.getParameterValues("hobbies");
        List<String> hobbies = hobbiesArray != null ? java.util.Arrays.asList(hobbiesArray) : java.util.Collections.emptyList();

        String classXBoard = request.getParameter("classXBoard");
        double classXPercentage = Double.parseDouble(request.getParameter("classXPercentage"));
        int classXYearOfPassing = Integer.parseInt(request.getParameter("classXYearOfPassing"));

        String classXIIBoard = request.getParameter("classXIIBoard");
        double classXIIPercentage = Double.parseDouble(request.getParameter("classXIIPercentage"));
        int classXIIYearOfPassing = Integer.parseInt(request.getParameter("classXIIYearOfPassing"));

        String graduationBoard = request.getParameter("graduationBoard");
        double graduationPercentage = Double.parseDouble(request.getParameter("graduationPercentage"));
        int graduationYearOfPassing = Integer.parseInt(request.getParameter("graduationYearOfPassing"));

        String masterBoard = request.getParameter("masterBoard");
        double masterPercentage = Double.parseDouble(request.getParameter("masterPercentage"));
        int masterYearOfPassing = Integer.parseInt(request.getParameter("masterYearOfPassing"));

        String courseAppliedFor = request.getParameter("courseAppliedFor");

    }


}
