package com.example.demo.models;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.util.List;

@Entity
public class Teacher {
    @Id
    @GeneratedValue
    private int teacherId;

    @NotNull(message = "Title must not be empty")
    private Title title;

    @NotNull(message = "First name must not be empty")
    @Size(min=2,message="First name must have a minimum length of 2 characters")
    private String teacherFirstName;

    @Size(max=1,message="Please limit the field to 1 character")
    @Pattern(regexp = "[A-z]",message = "Only alphabetical characters are allowed")
    private String teacherMiddleInitial;

    @NotNull (message = "Last name must have a minimum length of 2 characters")
    @Size(min=2)
    private String teacherLastName;

    @OneToMany(mappedBy = "teacherID", cascade = CascadeType.ALL)
    private List<Student> students;


    public Teacher() {}

    public int getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(int teacherId) {
        this.teacherId = teacherId;
    }

    public Title getTitle() {
        return title;
    }

    public void setTitle(Title title) {
        this.title = title;
    }

    public String getTeacherFirstName() {
        return teacherFirstName;
    }

    public void setTeacherFirstName(String teacherFirstName) {
        this.teacherFirstName = teacherFirstName;
    }

    public String getTeacherMiddleInitial() {
        return teacherMiddleInitial;
    }

    public void setTeacherMiddleInitial(String teacherMiddleInitial) {
        this.teacherMiddleInitial = teacherMiddleInitial;
    }

    public String getTeacherLastName() {
        return teacherLastName;
    }

    public void setTeacherLastName(String teacherLastName) {
        this.teacherLastName = teacherLastName;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }
}
