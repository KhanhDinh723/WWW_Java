package edu.iuh.fit.se.bookbe.dtos;

/**
 * Author: Khánh Đinh
 * Date:   10/30/2025
 * Time:   10:47 AM
 */
public class ApiResponse <T>{
    private int status;
    private String message;
    private T data;

    public ApiResponse() {
    }

    public ApiResponse(int status, String message, T data) {
        this.status = status;
        this.message = message;
        this.data = data;
    }

    public static <T> ApiResponse<T> ok(T data){
        return new ApiResponse<>(200,"OK",data);
    }
    public static <T> ApiResponse<T>created(T data){
        return new ApiResponse<>(201,"CREATE",data);
    }

    public int getStatus() {
        return status;
    }

    public String getMessage() {
        return message;
    }

    public T getData() {
        return data;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setData(T data) {
        this.data = data;
    }
}
