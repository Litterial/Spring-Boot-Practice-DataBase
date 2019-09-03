package com.example.demo.controllers;
import com.example.demo.models.Teacher;
import com.example.demo.models.Student;
import com.example.demo.models.Title;
import com.example.demo.services.StudentService;
import com.example.demo.services.TeacherService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.ui.Model;

import javax.jws.WebParam;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import org.springframework.validation.Errors;

@Controller
@RequestMapping(value="teachers")
public class TeacherController {
    @Autowired
    private TeacherService teacherService;
    @Autowired
    private StudentService studentService;



    @RequestMapping(value="")
    public String Teachers (Model model)
    {
        model.addAttribute("teachers",teacherService.allTeachers());
        System.out.println(teacherService.allTeachers());

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
    public String submitTeacher (@Valid Teacher teacher, Errors err, Model model)
    {
        System.out.println("TeacherController");
        if (err.hasErrors())
        {
            model.addAttribute("teacherTitle", Title.values());
            model.addAttribute("teacher",teacher);

            return "teacher/addTeacher";
        }


        System.out.println(teacher);
        teacherService.createTeacher(teacher);

        return "teacher/success";
    }
    @RequestMapping(value="edit/{id}",method = RequestMethod.GET)
    public String editTeacherForm (Model model, @PathVariable int id)
    {
        model.addAttribute("entry","teachers");
        if (!teacherService.existTeacher(id))
            return "teacher/noMatch";

        model.addAttribute("teacher",teacherService.findTeacher(id));
        model.addAttribute("allTitles",Title.values());
        return "teacher/edit";
    }

    @RequestMapping(value="edit/{id}",method = RequestMethod.POST)
    public String submitEditTeacher(@Valid Teacher teacher, Errors err, Model model, @PathVariable int id, HttpServletRequest request)
    {
        model.addAttribute("entry","teachers");
        if (!teacherService.existTeacher(id))
            return "noMatch";

        else if(err.hasErrors()) {
            model.addAttribute("teacher",teacher);
            model.addAttribute("allTitles",Title.values());
            return "teacher/edit";
        }

        else
        {
            String title=request.getParameter("title");
            String first=request.getParameter("teacherFirstName");
            String mid=request.getParameter("teacherMiddleInitial");
            String last=request.getParameter("teacherLastName");
            teacherService.updateTeacher(title,first,mid,last,id);
        }
        return "teacher/success";


    }
    @RequestMapping(value="delete/{id}",method = RequestMethod.GET)
    public String deleteTeacher(Model model, @PathVariable int id) {
        model.addAttribute("entry", "teachers");
        if (!teacherService.existTeacher(id))
            return "noMatch";
        model.addAttribute("teacher",teacherService.findTeacher(id));
        model.addAttribute("students",studentService.teacherStudents(id));
        System.out.println(studentService.teacherStudents(id).size());

        return "teacher/delete";
    } @RequestMapping(value="delete/{id}", method=RequestMethod.POST)
    public String deletedTeacher(Model model, @PathVariable int id)
    {
        if (!teacherService.existTeacher(id))
            return "noMatch";
        teacherService.deleteTeacherRepo(id);
        return "redirect:../";
    }

}
