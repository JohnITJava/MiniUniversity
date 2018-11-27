package ru.gorparkovki.MiniUniversity.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import ru.gorparkovki.MiniUniversity.Entity.Group;
import ru.gorparkovki.MiniUniversity.Entity.Student;
import ru.gorparkovki.MiniUniversity.Service.GroupService;
import ru.gorparkovki.MiniUniversity.Service.StudentService;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.CopyOnWriteArrayList;

import static java.util.UUID.randomUUID;

@Controller
public class GroupController {
    StudentController studentController = new StudentController();

    @Autowired
    GroupService groupService;

    private final ConcurrentMap<String, List<Student>> groups = new ConcurrentHashMap<>();
    //private final CopyOnWriteArrayList<Group> groups = new CopyOnWriteArrayList<>();


    @GetMapping("/group")
    @ResponseBody
    public ConcurrentMap<String, List<Student>> read() {
        return groups;
    }

    @GetMapping("/group/{group}")
    @ResponseBody
    public List<Student> read(@PathVariable(name = "group") String groupName) {
        //return groups.get(groupName);
        return groupService.get(groupName).getStudents();
    }

    @PostMapping("/group")
    @ResponseBody
    public Group create(@RequestBody Group newGroup) {
        //groups.put(newGroup.getGroup(), newGroup.getStudents());
        groupService.add(newGroup);
        return newGroup;
    }

}


