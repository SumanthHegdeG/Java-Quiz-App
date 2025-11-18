package com.sumanth.ExamPortal.Artifactname.service;


import com.sumanth.ExamPortal.Artifactname.dto.users.UserDTO;
import com.sumanth.ExamPortal.Artifactname.model.User;
import com.sumanth.ExamPortal.Artifactname.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    private UserDTO map(User u) {
        UserDTO dto = new UserDTO();
        dto.setId(u.getId());
        dto.setName(u.getName());
        dto.setPhone(u.getPhone());
        dto.setEmail(u.getEmail());
        dto.setRole(u.getRole());
        return dto;
    }

    public List<UserDTO> getAllTeachers() {
        return userRepository.findAll().stream()
                .filter(u -> "TEACHER".equals(u.getRole()))
                .map(this::map)
                .toList();
    }

    public List<UserDTO> getAllStudents() {
        return userRepository.findAll().stream()
                .filter(u -> "STUDENT".equals(u.getRole()))
                .map(this::map)
                .toList();
    }

}

