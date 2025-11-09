package edu.iuh.fit.se.bep1.dtos;

/**
 * Author: Khánh Đinh
 * Date:   10/29/2025
 * Time:   9:26 PM
 */
public class ApiResponse <T>{
    private int status;
    private T data;

    public ApiResponse() {
    }

    public ApiResponse(int status, T data) {
        this.status = status;
        this.data = data;
    }

    public int getStatus() {
        return status;
    }

    public T getData() {
        return data;
    }
}
