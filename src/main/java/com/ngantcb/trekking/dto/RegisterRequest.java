package com.ngantcb.trekking.dto;

import lombok.Data;

@Data
public class RegisterRequest {

    private String email;
    private String password;
    private String lName;
    private String fName;
}
