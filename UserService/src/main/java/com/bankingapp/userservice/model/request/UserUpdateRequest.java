package com.bankingapp.userservice.model.request;

import com.bankingapp.userservice.model.Status;
import lombok.Data;

@Data
public class UserUpdateRequest {
    private Status status;

}
