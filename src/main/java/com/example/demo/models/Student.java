package com.example.demo.models;

import javax.persistence.*;
import javax.validation.constraints.*;

@Entity
public class Student {

    @Id
    @GeneratedValue
    private int studentID;

    @NotNull(message = "First name must not be empty")
    @Size(min=2,message = "First name must not be empty")
    private String studentFirstName;

    @Size(max=1,message = "Please limit the field to 1 character")
    @Pattern(regexp = "[A-z]?",message = "Only alphabetical characters are allowed")
    private String studentMiddleInitial;

    @NotNull(message = "Last name must not be empty")
    @Size(min=2,message = "Last name must have a minimum of 2 characters")
    private String studentLastName;

    @ManyToOne
    @JoinColumn(name ="teacher_Id")
    private Teacher teacherID;

    public Student(){}

    public int getStudentID() {
        return studentID;
    }

    public void setStudentID(int studentID) {
        this.studentID = studentID;
    }

    public String getStudentFirstName() {
        return studentFirstName;
    }

    public void setStudentFirstName(String studentFirstName) {
        this.studentFirstName = studentFirstName;
    }

    public String getStudentMiddleInitial() {
        return studentMiddleInitial;
    }

    public void setStudentMiddleInitial(String studentMiddleInitial) {
        this.studentMiddleInitial = studentMiddleInitial;
    }

    public String getStudentLastName() {
        return studentLastName;
    }

    public void setStudentLastName(String studentLastName) {
        this.studentLastName = studentLastName;
    }

    public Teacher getTeacherID() {
        return teacherID;
    }

    public void setTeacherID(Teacher teacherID) {
        this.teacherID = teacherID;
    }
}
