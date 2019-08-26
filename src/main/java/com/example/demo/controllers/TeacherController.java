package com.example.demo.controllers;
import com.example.demo.models.Teacher;
import com.example.demo.models.Title;
import com.example.demo.services.TeacherService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.ui.Model;
@Controller
@RequestMapping(value="teacher")
public class TeacherController {
    @Autowired
    private TeacherService teacherService;

    @RequestMapping(value="add", method = RequestMethod.GET)
    public String addTeacher (Model model)
    {
        model.addAttribute("teacherTitle", Title.values());
        model.addAttribute("teacher",new Teacher());

        return"teacher/add";
    }

}
