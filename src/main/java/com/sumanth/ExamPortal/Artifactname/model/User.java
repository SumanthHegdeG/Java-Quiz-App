package com.sumanth.ExamPortal.Artifactname.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import lombok.*;

import java.time.Instant;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "users")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor @Builder
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @Column(unique = true)
    private String phone;

    @Email
    private String email;

    @Column(name = "password_hash")
    private String passwordHash;

    private String role; // INVIGILATOR / TEACHER / STUDENT

    @Column(name = "registration_allowed")
    private Boolean registrationAllowed = false;

    @Column(name = "created_at")
    private Instant createdAt = Instant.now();
}