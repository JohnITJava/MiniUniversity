package ru.gorparkovki.MiniUniversity.Entity;

import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;

@Document
public class Teacher {
    private String name;
    private List<Group> groups;

    public Teacher() {
    }

    public Teacher(String name, Group group) {
        this.name = name;
        this.groups.add(group);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Group> getGroups() {
        return groups;
    }

    public void setGroups(List<Group> groups) {
        this.groups = groups;
    }
}
