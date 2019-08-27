package com.example.demo.controllers;

import com.example.demo.services.StudentService;
import com.example.demo.services.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value="students")
public class StudentController {
    @Autowired
    private StudentService studentService;
    private TeacherService teacherService;

    @RequestMapping(value="")
    public String allStudents (Model model)
    {
        model.addAttribute("students",studentService.allStudents());
        return"student/index";
    }

//    @RequestMapping(value="addStudent/{id}")
//
//    public String addStudent(Model model)
//    {
//
//    }
}
