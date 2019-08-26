package com.example.demo.models;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.util.List;
@Entity
public class Teacher {
    @Id
    @GeneratedValue
    private int teacherId;

    @NotNull
    private Title title;

    @NotNull
    @Size(min=2)
    private String teacherFirstName;

    @Size(max=1)
    private String teacherMiddleInitial;

    @NotNull
    @Size(min=2)
    private String teacherLastName;

    @OneToMany(mappedBy = "teacherID", cascade = CascadeType.ALL)
    private List<Student> students;


    public Teacher() {}
    public int getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(int id) {
        teacherId = id;
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

    public void setTeacherFirstName(String firstName) {
        this.teacherFirstName = firstName;
    }

    public String getTeacherMiddleInitial() {
        return teacherMiddleInitial;
    }

    public void setTeacherMiddleInitial(String middleInitial) {
        this.teacherMiddleInitial = middleInitial;
    }

    public String getTeacherLastName(){
        return this.teacherLastName;
    }

    public void setTeacherLastName(String lastName) {
        this.teacherLastName = lastName;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

}
