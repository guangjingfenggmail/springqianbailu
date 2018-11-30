package com.open.springqianbailu;

public class Result<T> {
    public Integer status;
    public String message;
    public T data;


    public static Result success(Object object) {
        Result result = new Result();
        result.data = object;
        result.message = "Success";
        result.status = 200;
        return result;
    }

    public static Result error(Integer status, String message) {
        Result result = new Result();
        result.message = message;
        result.status = status;
        return result;
    }
}
