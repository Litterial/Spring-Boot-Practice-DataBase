package com.example.demo.services;

import java.util.List;

import com.example.demo.repositories.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.models.Teacher;
import com.example.demo.models.Title;
@Service
public class TeacherService {
    @Autowired
    private TeacherRepository teacherRepo;

    public List<Teacher> allTeachers ()
    {
     return teacherRepo.findAll();
    }


    public void createTeacher (Teacher teacher)
    {
        System.out.println("TeacherService");
        System.out.println(teacher);
        teacherRepo.save(teacher);

    }

    public Teacher findTeacher(int id)
    {
       return teacherRepo.getOne(id);

    }

    public Boolean existTeacher(int id)
    {

//        System.out.println(teacherRepo.existsById(id));
        return teacherRepo.existsById(id);
    }

    public void updateTeacher(String title,String fName, String middle, String lName, int id)
    {
        Teacher teacher=findTeacher(id);
        teacher.setTitle(Title.valueOf(title));
        teacher.setTeacherFirstName(fName);
        teacher.setTeacherMiddleInitial(middle);
        teacher.setTeacherLastName(lName);
        teacherRepo.save(teacher);
    }



}
