package ru.gorparkovki.MiniUniversity.Repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.stereotype.Repository;
import ru.gorparkovki.MiniUniversity.Entity.Student;

import java.util.List;

@Repository
public class StudentRepository {

    @Autowired
    private MongoOperations mongoOperations;

    public void save(Student student) {
        mongoOperations.save(student);
    }

    public void saveAll(Student... students) {
        for (int i = 0; i < students.length; i++) {
            mongoOperations.save(students[i]);
        }
    }

    public List<Student> getAll() {
        return mongoOperations.findAll(Student.class);
    }

}
