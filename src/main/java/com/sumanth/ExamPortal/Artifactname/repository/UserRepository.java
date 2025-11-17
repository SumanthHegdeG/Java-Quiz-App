package com.sumanth.ExamPortal.Artifactname.repository;

import com.sumanth.ExamPortal.Artifactname.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User,Long> {

    Optional<User>  findByPhone(String Phone);
    boolean existsByPhone(String PhoneNumber);

}
