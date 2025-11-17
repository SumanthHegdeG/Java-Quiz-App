package com.sumanth.ExamPortal.Artifactname.dto.authentication;

import lombok.Data;

@Data
public class SignUpRequest {
    private String name;
    private String password;
    private String phone;
    private String email;
}
