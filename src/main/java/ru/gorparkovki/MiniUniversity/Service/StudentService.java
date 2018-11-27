package ru.gorparkovki.MiniUniversity.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.gorparkovki.MiniUniversity.Entity.Student;
import ru.gorparkovki.MiniUniversity.Repository.StudentRepository;

import java.util.List;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    public void add(Student student) {
        studentRepository.save(student);
    }

    public void addAll(Student... students) {
        studentRepository.saveAll(students);
    }

    public List<Student> getAll() {
        return studentRepository.getAll();
    }

}
