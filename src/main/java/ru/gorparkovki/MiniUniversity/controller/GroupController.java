package ru.gorparkovki.MiniUniversity.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import ru.gorparkovki.MiniUniversity.Entity.Group;
import ru.gorparkovki.MiniUniversity.Entity.Student;
import ru.gorparkovki.MiniUniversity.Service.GroupService;

import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

@Controller
public class GroupController {

    @Autowired
    GroupService groupService;

    @GetMapping("/group")
    @ResponseBody
    public List<Group> read() {
        return groupService.getAll();
    }

    @GetMapping("/group/{group}")
    @ResponseBody
    public List<Student> read(@PathVariable(name = "group") String groupName) {
        return groupService.getOne(groupName).getStudents();
    }

    @PutMapping("/group")
    @ResponseBody
    public List<Student> update(@RequestHeader String group){
            return groupService.getOne(group).getStudents();
    }


    @PostMapping("/group")
    @ResponseBody
    public Group create(@RequestBody Group newGroup) {
        groupService.add(newGroup);
        return newGroup;
    }

}


