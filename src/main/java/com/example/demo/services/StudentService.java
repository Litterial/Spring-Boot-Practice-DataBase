package com.example.demo.services;

import com.example.demo.models.Student;
import com.example.demo.models.Teacher;
import com.example.demo.repositories.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {
    @Autowired
    private StudentRepository studentRepository;
    @Autowired
    private TeacherService teacherService;

    public List<Student> allStudents()
    {
        return studentRepository.findAll();
    }


    public void createStudent(Student student, int id)
    {
        Teacher teacherId= teacherService.findTeacher(id);
        student.setTeacherID(teacherId);
        studentRepository.save(student);
    }

    public Boolean existStudent(int id)
    {
        return studentRepository.existsById(id);
    }

    public Student findStudent(int id)
    {
        return studentRepository.getOne(id);
    }

    public void updateStudent(String fName, String middle, String lName, int id)
    {
        Student student=findStudent(id);
        student.setStudentFirstName(fName);
        student.setStudentMiddleInitial(middle);
        student.setStudentLastName(lName);
        studentRepository.save(student);
    }
    public List<Student> teacherStudents (int id)
    {
      return studentRepository.allTeacherStudents(id);
    }

}
