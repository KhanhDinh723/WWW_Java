package edu.iuh.fit.se.servlet_t1.entities;

/**
 * Author: Khánh Đinh
 * Date:   8/28/2025
 * Time:   1:59 PM
 */
public class User {
    private int id;
    private String userName;
    private String passWord;
    public User(int id, String userName, String passWord) {
        super();
        this.id = id;
        this.userName = userName;
        this.passWord = passWord;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getUserName() {
        return userName;
    }
    public void setUserName(String userName) {
        this.userName = userName;
    }
    public String getPassWord() {
        return passWord;
    }
    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }
    @Override
    public String toString() {
        return "User [id=" + id + ", userName=" + userName + ", passWord=" + passWord + "]";
    }


}

