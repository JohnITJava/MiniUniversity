package ru.gorparkovki.MiniUniversity.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import ru.gorparkovki.MiniUniversity.Entity.Student;
import ru.gorparkovki.MiniUniversity.Repository.StudentRepository;
import ru.gorparkovki.MiniUniversity.Service.StudentService;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

@Controller
public class StudentController {

    @Autowired
    StudentService studentService;

    @GetMapping("/student")
    @ResponseBody
    public List<Student> read() {
        return studentService.getAll();
    }

    @PostMapping("/student")
    @ResponseBody
    public List<Student> create(@RequestBody Student... newStudents) {
        return Arrays.asList(newStudents);
    }
}
