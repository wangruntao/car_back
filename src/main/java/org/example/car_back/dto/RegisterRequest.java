package org.example.car_back.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.NonNull;

@Data
public class RegisterRequest {

    @NotNull
    private String username;
    @NotNull
    private String password;
    @NotNull
    private String contactInfo;

}