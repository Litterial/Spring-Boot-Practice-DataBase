package com.example.demo.services;

import com.example.demo.models.Student;
import com.example.demo.models.Teacher;
import com.example.demo.repositories.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {
    @Autowired
    private StudentRepository studentRepository;

    public List<Student> allStudents()
    {
        return studentRepository.findAll();
    }

    public void createStudent(Student student,Teacher teacher)
    {
        student.setTeacherID(teacher);
        studentRepository.save(student);
    }


}
