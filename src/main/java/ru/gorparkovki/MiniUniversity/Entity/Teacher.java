package ru.gorparkovki.MiniUniversity.Entity;

import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;

@Document
public class Teacher {
    private String teacher;
    private String group;

    public Teacher() {
    }

    public Teacher(String name, String group) {
        this.teacher = name;
        this.group = group;
    }

    public String getTeacher() {
        return teacher;
    }

    public void setTeacher(String teacher) {
        this.teacher = teacher;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }
}
