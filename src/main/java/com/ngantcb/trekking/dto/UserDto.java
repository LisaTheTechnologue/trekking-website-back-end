package com.ngantcb.trekking.dto;

import com.ngantcb.trekking.enums.UserRole;
import lombok.Data;

@Data
public class UserDto {

    private Long id;
    private String email;
    private String lName;
    private String fName;
    private UserRole role;
}
