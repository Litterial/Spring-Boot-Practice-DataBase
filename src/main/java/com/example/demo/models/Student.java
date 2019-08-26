package com.example.demo.models;

import javax.persistence.*;
import javax.validation.constraints.*;

@Entity
public class Student {

    @Id
    @GeneratedValue
    private int studentID;

    @NotNull
    @Size(min=2)
    private String studentFirstName;

    @Size(min=1)
    private String studentMiddleInitial;

    @NotNull
    @Size(min=2)
    private String studentLastName;

    @ManyToOne
    @JoinColumn(name ="teacher_Id")
    private Teacher teacherID;

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
