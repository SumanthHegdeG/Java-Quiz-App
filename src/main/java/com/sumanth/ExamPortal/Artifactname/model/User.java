package com.sumanth.ExamPortal.Artifactname.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import lombok.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(exclude = "examsCreated")
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(columnDefinition = "TEXT")
    private String name;

    @Column(length = 20,unique = true)
    private String phone;

    @Email
    @Column(length = 255)
    private String email;

    @Column(columnDefinition = "TEXT")
    private String PasswordHash;

    @Column(length = 50)
    private String role;

    @Column(name="registration_allowed")
    private Boolean registrationAllowed=false;

    @Column(name="created_at",nullable = false,updatable = false)
    private LocalDateTime createdAt;

    @OneToMany(mappedBy = "createdBy", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Exam> examsCreated = new ArrayList<>();

    @PrePersist
    protected void onCreate(){
        this.createdAt=LocalDateTime.now();
    }


}
