package org.example.car_back.common;

import lombok.Data;
import org.springframework.validation.FieldError;

import java.util.List;

@Data
public class R {

    private int code;

    private String message;

    private String type;

    private Boolean success;

    private Object data;

    public static R success(String message) {
        R r = new R();
        r.setCode(200);
        r.setMessage(message);
        r.setSuccess(true);
        r.setType("success");
        r.setData(null);
        return r;
    }
    public static R success(Object object) {
        R r = new R();
        r.setCode(200);
        r.setData(object);
        r.setSuccess(true);
        r.setType("success");
        r.setData(null);
        return r;
    }

    public static R success(String message, Object data) {
        R r = success(message);
        r.setData(data);
        return r;
    }

    public static R error(String message) {
        R r = success(message);
        r.setSuccess(false);
        r.setCode(400);
        r.setType("error");
        return r;
    }

    public static R fatal(String message) {
        R r = error(message);
        r.setCode(500);
        return r;
    }

    public static R result(boolean isSuccessful, String successMessage, String errorMessage) {
        return isSuccessful ? success(successMessage) : error(errorMessage);
    }


    public static R error(int value, String s) {
        R r = new R();
        r.setCode(value);
        r.setMessage(s);
        r.setSuccess(false);
        r.setType("error");
        return r;
    }
}
