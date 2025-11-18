package com.sumanth.ExamPortal.Artifactname.service;


import com.sumanth.ExamPortal.Artifactname.repository.ExamRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ExamService {

    private final ExamRepository examRepository;


}
