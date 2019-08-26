package com.example.demo.services;

import com.example.demo.repositories.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.models.Teacher;

@Service
public class TeacherService {
    @Autowired
    private TeacherRepository teacherRepo;
    
    public void createTeacher (Teacher teacher)
    {
        
    }
    
}
