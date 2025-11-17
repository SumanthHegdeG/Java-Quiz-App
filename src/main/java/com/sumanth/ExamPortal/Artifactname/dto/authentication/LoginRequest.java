package com.sumanth.ExamPortal.Artifactname.dto.authentication;


import lombok.Data;

@Data
public class LoginRequest {
    private String phone;
    private String password;
}
