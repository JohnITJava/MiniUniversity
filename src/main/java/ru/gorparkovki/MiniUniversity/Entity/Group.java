package ru.gorparkovki.MiniUniversity.Entity;

import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.Arrays;

@Document
public class Group {
    private String group;
    private ArrayList<Student> students;
    private String teacherName = "";

    public Group() {
    }

    public Group(String name, Student... students) {
        this.group = name;
        this.students = new ArrayList<>(Arrays.asList(students));
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public ArrayList<Student> getStudents() {
        return students;
    }

    public void setStudents(ArrayList<Student> students) {
        this.students = students;
    }

    public String getTeacherName() {
        return teacherName;
    }

    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName;
    }
}
