package edu.iuh.fit.se.Bai1.model;

import java.time.LocalDate;
import java.util.List;

/**
 * Author: Khánh Đinh
 * Date:   9/11/2025
 * Time:   3:01 PM
 */
public class Student {
    private String firstName;
    private String lastName;
    private LocalDate dateOfBirth;
    private String email;
    private String phoneNumber;
    private String gender; // true
    private String address;
    private String city;
    private int pinCode;
    private String state;
    private String country;
    private List<String> hobbies;
    // Qualification details
    private String classXBoard;
    private double classXPercentage;
    private int classXYearOfPassing;

    private String classXIIBoard;
    private double classXIIPercentage;
    private int classXIIYearOfPassing;

    private String graduationBoard;
    private double graduationPercentage;
    private int graduationYearOfPassing;

    private String masterBoard;
    private double masterPercentage;
    private int masterYearOfPassing;

    private String courseAppliedFor;

    public Student() {
    }

    public Student(String firstName, String lastName, LocalDate dateOfBirth, String email, String phoneNumber, String gender, String address, String city, int pinCode, String state, String country, List<String> hobbies, String classXBoard, double classXPercentage, int classXYearOfPassing, String classXIIBoard, double classXIIPercentage, int classXIIYearOfPassing, String graduationBoard, double graduationPercentage, int graduationYearOfPassing, String masterBoard, double masterPercentage, int masterYearOfPassing, String courseAppliedFor) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.gender = gender;
        this.address = address;
        this.city = city;
        this.pinCode = pinCode;
        this.state = state;
        this.country = country;
        this.hobbies = hobbies;
        this.classXBoard = classXBoard;
        this.classXPercentage = classXPercentage;
        this.classXYearOfPassing = classXYearOfPassing;
        this.classXIIBoard = classXIIBoard;
        this.classXIIPercentage = classXIIPercentage;
        this.classXIIYearOfPassing = classXIIYearOfPassing;
        this.graduationBoard = graduationBoard;
        this.graduationPercentage = graduationPercentage;
        this.graduationYearOfPassing = graduationYearOfPassing;
        this.masterBoard = masterBoard;
        this.masterPercentage = masterPercentage;
        this.masterYearOfPassing = masterYearOfPassing;
        this.courseAppliedFor = courseAppliedFor;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public int getPinCode() {
        return pinCode;
    }

    public void setPinCode(int pinCode) {
        this.pinCode = pinCode;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public List<String> getHobbies() {
        return hobbies;
    }

    public void setHobbies(List<String> hobbies) {
        this.hobbies = hobbies;
    }

    public String getClassXBoard() {
        return classXBoard;
    }

    public void setClassXBoard(String classXBoard) {
        this.classXBoard = classXBoard;
    }

    public double getClassXPercentage() {
        return classXPercentage;
    }

    public void setClassXPercentage(double classXPercentage) {
        this.classXPercentage = classXPercentage;
    }

    public int getClassXYearOfPassing() {
        return classXYearOfPassing;
    }

    public void setClassXYearOfPassing(int classXYearOfPassing) {
        this.classXYearOfPassing = classXYearOfPassing;
    }

    public String getClassXIIBoard() {
        return classXIIBoard;
    }

    public void setClassXIIBoard(String classXIIBoard) {
        this.classXIIBoard = classXIIBoard;
    }

    public double getClassXIIPercentage() {
        return classXIIPercentage;
    }

    public void setClassXIIPercentage(double classXIIPercentage) {
        this.classXIIPercentage = classXIIPercentage;
    }

    public int getClassXIIYearOfPassing() {
        return classXIIYearOfPassing;
    }

    public void setClassXIIYearOfPassing(int classXIIYearOfPassing) {
        this.classXIIYearOfPassing = classXIIYearOfPassing;
    }

    public String getGraduationBoard() {
        return graduationBoard;
    }

    public void setGraduationBoard(String graduationBoard) {
        this.graduationBoard = graduationBoard;
    }

    public double getGraduationPercentage() {
        return graduationPercentage;
    }

    public void setGraduationPercentage(double graduationPercentage) {
        this.graduationPercentage = graduationPercentage;
    }

    public int getGraduationYearOfPassing() {
        return graduationYearOfPassing;
    }

    public void setGraduationYearOfPassing(int graduationYearOfPassing) {
        this.graduationYearOfPassing = graduationYearOfPassing;
    }

    public String getMasterBoard() {
        return masterBoard;
    }

    public void setMasterBoard(String masterBoard) {
        this.masterBoard = masterBoard;
    }

    public double getMasterPercentage() {
        return masterPercentage;
    }

    public void setMasterPercentage(double masterPercentage) {
        this.masterPercentage = masterPercentage;
    }

    public int getMasterYearOfPassing() {
        return masterYearOfPassing;
    }

    public void setMasterYearOfPassing(int masterYearOfPassing) {
        this.masterYearOfPassing = masterYearOfPassing;
    }

    public String getCourseAppliedFor() {
        return courseAppliedFor;
    }

    public void setCourseAppliedFor(String courseAppliedFor) {
        this.courseAppliedFor = courseAppliedFor;
    }

    public int getAge() {
        if (dateOfBirth != null) {
            return LocalDate.now().getYear() - dateOfBirth.getYear();
        }
        return 0;
    }

    @Override
    public String toString() {
        return "Student{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", dateOfBirth=" + dateOfBirth +
                ", email='" + email + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", gender='" + gender + '\'' +
                ", address='" + address + '\'' +
                ", city='" + city + '\'' +
                ", pinCode=" + pinCode +
                ", state='" + state + '\'' +
                ", country='" + country + '\'' +
                ", hobbies=" + hobbies +
                ", classXBoard='" + classXBoard + '\'' +
                ", classXPercentage=" + classXPercentage +
                ", classXYearOfPassing=" + classXYearOfPassing +
                ", classXIIBoard='" + classXIIBoard + '\'' +
                ", classXIIPercentage=" + classXIIPercentage +
                ", classXIIYearOfPassing=" + classXIIYearOfPassing +
                ", graduationBoard='" + graduationBoard + '\'' +
                ", graduationPercentage=" + graduationPercentage +
                ", graduationYearOfPassing=" + graduationYearOfPassing +
                ", masterBoard='" + masterBoard + '\'' +
                ", masterPercentage=" + masterPercentage +
                ", masterYearOfPassing=" + masterYearOfPassing +
                ", courseAppliedFor='" + courseAppliedFor + '\'' +
                '}';
    }
}
