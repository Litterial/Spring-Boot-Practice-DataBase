package com.example.demo.controllers;

import com.example.demo.models.Student;
import com.example.demo.models.Teacher;
import com.example.demo.services.StudentService;
import com.example.demo.services.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;

@Controller
@RequestMapping(value="students")
public class StudentController {
    @Autowired
    private StudentService studentService;
    @Autowired
    private TeacherService teacherService;

    @RequestMapping(value="")
    public String allStudents (Model model)
    {
        model.addAttribute("student",studentService.allStudents());
        return"student/index";
    }

    @RequestMapping(value="addStudent/{id}",method = RequestMethod.GET)

    public String addStudent(Model model,@PathVariable int id)
    {
        System.out.println(id);
        if(!teacherService.existTeacher(id)) {
            return "teacher/noMatch";
        }
        model.addAttribute("student",new Student());
        return "student/addStudent";

    }

    @RequestMapping(value="addStudent/{id}",method = RequestMethod.POST)
    public String submitStudent(@Valid @ModelAttribute("student") Student newStudent, Errors err, @PathVariable int id)
    {
        if(!teacherService.existTeacher(id))
            return "teacher/noMatch";

        if (err.hasErrors())
            return "student/addStudent";

        studentService.createStudent(newStudent,id);
        return"student/success";
    }
}
