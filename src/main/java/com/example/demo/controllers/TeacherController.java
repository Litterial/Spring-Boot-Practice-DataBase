package com.example.demo.controllers;
import com.example.demo.models.Teacher;
import com.example.demo.models.Title;
import com.example.demo.services.TeacherService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.ui.Model;

import javax.jws.WebParam;
import javax.validation.Valid;
import org.springframework.validation.Errors;

@Controller
@RequestMapping(value="teacher")
public class TeacherController {
    @Autowired
    private TeacherService teacherService;


    @RequestMapping(value="")
    public String Teachers (Model model)
    {
        model.addAttribute("teachers",teacherService.allTeachers());

        return "teacher/index";
    }
    @RequestMapping(value="add", method = RequestMethod.GET)
    public String addTeacher (Model model)
    {
        model.addAttribute("teacherTitle", Title.values());
        model.addAttribute("teacher",new Teacher());

        return "teacher/addTeacher";
    }

    @RequestMapping(value="add", method = RequestMethod.POST)
    public String submitTeacher (@Valid Teacher teacher, Errors err)
    {
        System.out.println("TeacherController");
        if (err.hasErrors())
        {
            return "teacher/addTeacher";
        }


        System.out.println(teacher);
        teacherService.createTeacher(teacher);

        return "teacher/success";
    }

}
