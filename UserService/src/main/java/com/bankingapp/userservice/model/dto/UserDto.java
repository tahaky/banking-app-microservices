package com.bankingapp.userservice.model.dto;


import com.bankingapp.userservice.model.Status;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {
    private String email;

    private String identification;

    private String password;

    private String authId;

    private Status status;
}
