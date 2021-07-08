package com.tbread.myloginlessblog.Dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Email;

@Setter
@Getter
public class SignupRequestDto {
    private String username;
    private String password;

    private String email;
    private boolean admin = false;
    private String adminToken = "";
}