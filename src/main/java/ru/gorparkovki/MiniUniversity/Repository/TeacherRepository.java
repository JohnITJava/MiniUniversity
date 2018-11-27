package ru.gorparkovki.MiniUniversity.Repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;
import ru.gorparkovki.MiniUniversity.Entity.Group;
import ru.gorparkovki.MiniUniversity.Entity.Teacher;


@Repository
public class TeacherRepository {

    @Autowired
    private MongoOperations mongoOperations;

    public void save(Teacher teacher) {
        mongoOperations.save(teacher);
    }



}
