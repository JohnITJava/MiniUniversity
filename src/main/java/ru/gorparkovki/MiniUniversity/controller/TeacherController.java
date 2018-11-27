package ru.gorparkovki.MiniUniversity.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import ru.gorparkovki.MiniUniversity.Entity.Group;
import ru.gorparkovki.MiniUniversity.Entity.Student;
import ru.gorparkovki.MiniUniversity.Entity.Teacher;
import ru.gorparkovki.MiniUniversity.Service.GroupService;
import ru.gorparkovki.MiniUniversity.Service.TeacherService;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.stream.Collectors;

@Controller
public class TeacherController {
    StudentController studentController = new StudentController();

    @Autowired
    TeacherService teacherService;

    @GetMapping("/teacher/{name}/groups")
    @ResponseBody
    public List<Group> readGroups(@PathVariable(name = "name") String teacherName) {
        List list = teacherService.getGroupByTeacher(teacherName).stream().map(Group::getGroup).collect(Collectors.toList());
        return list;
    }

    @GetMapping("/teacher/{name}/students")
    @ResponseBody
    public List<Student> readStudents(@PathVariable(name = "name") String teacherName) {
        List list = teacherService.getGroupByTeacher(teacherName).stream().map(Group::getStudents).collect(Collectors.toList());
        return list;
    }

    @PostMapping("/teacher")
    @ResponseBody
    public Teacher create(@RequestBody Teacher newTeacher) {
        teacherService.add(newTeacher);
        return newTeacher;
    }


}


