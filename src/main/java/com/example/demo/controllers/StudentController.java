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

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import javax.validation.constraints.Pattern;

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
        model.addAttribute("entry","teachers");
        if(!teacherService.existTeacher(id)) {
            return "teacher/noMatch";
        }
        model.addAttribute("student",new Student());
        return "student/addStudent";

    }

    @RequestMapping(value="addStudent/{id}",method = RequestMethod.POST)
    public String submitStudent(@Valid @ModelAttribute("student") Student newStudent, Errors err, Model model, @PathVariable int id, HttpServletRequest request)
    {
        model.addAttribute("entry","teachers");
        if(!teacherService.existTeacher(id))
            return "noMatch";

        if (err.hasErrors()) {
            System.out.println("There is an error");
            model.addAttribute("student",newStudent);
            return "student/addStudent";
        }
        System.out.println("Create a student");
        studentService.createStudent(newStudent,id);
        return"student/success";
    }
    @RequestMapping(value = "edit/{id}",method = RequestMethod.GET)
    public String editStudentForm(Model model, @PathVariable int id)
    {
        model.addAttribute("entry","students");
        if(!studentService.existStudent(id))
            return "noMatch";

        model.addAttribute("student",studentService.findStudent(id));
        return"student/edit";
    }

    @RequestMapping(value = "edit/{id}",method = RequestMethod.POST)
    public String editSubmitEdit(@Valid Student student, Errors err,  Model model, @PathVariable int id, HttpServletRequest request)
    {
        model.addAttribute("entry","students");
        if(!studentService.existStudent(id))
            return "noMatch";

        else if (err.hasErrors())
        {
            model.addAttribute("student",student);
            return"student/edit";
        }
        else
        {
            String first=request.getParameter("studentFirstName");
            String mid=request.getParameter("studentMiddleInitial");
            String last=request.getParameter("studentLastName");
            studentService.updateStudent(first,mid,last,id);
        }
        return"student/success";
    }
    @RequestMapping(value="delete/{id}",method = RequestMethod.GET)
    public String deleteStudent(Model model, @PathVariable int id) {
        model.addAttribute("entry", "students");
        if (!studentService.existStudent(id))
            return "noMatch";
        model.addAttribute("student",studentService.findStudent(id));


        return "student/delete";
    }

}

