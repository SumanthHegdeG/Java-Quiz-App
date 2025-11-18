package com.sumanth.ExamPortal.Artifactname.service;

import com.sumanth.ExamPortal.Artifactname.dto.authentication.JwtResponse;
import com.sumanth.ExamPortal.Artifactname.dto.authentication.LoginRequest;
import com.sumanth.ExamPortal.Artifactname.dto.authentication.SignUpRequest;
import com.sumanth.ExamPortal.Artifactname.model.User;
import com.sumanth.ExamPortal.Artifactname.repository.UserRepository;
import com.sumanth.ExamPortal.Artifactname.security.JwtUtils;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {
  private final UserRepository userRepository;
  private final JwtUtils jwtUtils;

  private BCryptPasswordEncoder encoder=new BCryptPasswordEncoder();

     public JwtResponse login(LoginRequest req) {
        User user = userRepository.findByPhone(req.getPhone())
                .orElseThrow(() -> new RuntimeException("User not found"));


        if (!encoder.matches(req.getPassword(), user.getPasswordHash())) {
            throw new RuntimeException("Invalid credentials");
        }

        String token = jwtUtils.generateToken(user.getPhone(), user.getRole());
        return new JwtResponse(token, "Bearer", user.getRole());
    }

    public User createUserByInvigilator(SignUpRequest req, String role) {
        if (userRepository.existsByPhone(req.getPhone())) {
            throw new RuntimeException("User already exists");
        }

        User u = User.builder()
                .name(req.getName())
                .phone(req.getPhone())
                .email(req.getEmail())
                .passwordHash(encoder.encode(req.getPassword()))
                .role(role)
                .registrationAllowed(true)
                .build();

        return userRepository.save(u);
    }

    public User registerByPhone(SignUpRequest req) {
        User existing = userRepository.findByPhone(req.getPhone())
                .orElseThrow(() -> new RuntimeException("Not invited"));

        if (!existing.getRegistrationAllowed()) {
            throw new RuntimeException("Registration not allowed");
        }

        existing.setName(req.getName());
        existing.setEmail(req.getEmail());
        existing.setPasswordHash(encoder.encode(req.getPassword()));
        existing.setRegistrationAllowed(false);


        return userRepository.save(existing);
    }

}
