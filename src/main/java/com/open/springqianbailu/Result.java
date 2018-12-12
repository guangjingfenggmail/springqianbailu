package com.open.springqianbailu;

import java.io.Serializable;

public class Result<T> implements Serializable {
    public Integer code;
    public String indo;
    public String desc;
    public T data;


    public static Result success(Object object) {
        Result result = new Result();
        result.data = object;
        result.indo = "Success";
        result.code = 200;
        return result;
    }

    public static Result error(Integer status, String message) {
        Result result = new Result();
        result.indo = message;
        result.code = status;
        return result;
    }

    public static Result error(Integer status, String message,String desc) {
        Result result = new Result();
        result.indo = message;
        result.code = status;
        result.desc = desc;
        return result;
    }
}
