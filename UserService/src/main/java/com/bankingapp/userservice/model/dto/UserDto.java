package com.bankingapp.userservice.model.dto;


import com.bankingapp.userservice.model.Status;
import lombok.Data;

@Data
public class UserDto {
    private String email;

    private String identification;

    private String password;

    private String authId;

    private Status status;
}
