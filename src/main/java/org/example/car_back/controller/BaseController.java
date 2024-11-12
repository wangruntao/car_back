package org.example.car_back.controller;

import org.example.car_back.common.R;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public abstract class BaseController {

    protected R validateBindingResult(BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            StringBuilder sb = new StringBuilder();
            for (org.springframework.validation.FieldError error : bindingResult.getFieldErrors()) {
                sb.append(error.getField()).append(": ").append(error.getDefaultMessage()).append("; ");
            }
            return R.error(HttpStatus.BAD_REQUEST.value(), "Invalid input: " + sb.toString());
        }
        return null;
    }
}
