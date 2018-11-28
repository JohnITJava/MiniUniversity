package ru.gorparkovki.MiniUniversity.Repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Repository;
import ru.gorparkovki.MiniUniversity.Entity.Group;

import java.util.List;


@Repository
public class GroupRepository {

    @Autowired
    private MongoOperations mongoOperations;

    public void save(Group group) {
        mongoOperations.save(group);
    }

    public Group getOne(String group) {
        return mongoOperations.findOne(Query.query(Criteria.where("group").is(group)), Group.class);
    }

    public List<Group> getAll() {
        return mongoOperations.findAll(Group.class);
    }

    public List<Group> getByName(String name) {
        return mongoOperations.find(Query.query(Criteria.where("group").is(name)), Group.class);
    }

    public List<Group> getByTeacher(String teacherName) {
        return mongoOperations.find(Query.query(Criteria.where("teacherName").is(teacherName)), Group.class);
    }

    public void updateTeacher(Group group, String teacherName){
        Query query = new Query();
        query.addCriteria(Criteria.where("group").is(group.getGroup()));
        Update update = new Update();
        update.set("teacherName", teacherName);
        mongoOperations.updateFirst(query, update, Group.class);
    }

    public void setMongoOperations(MongoOperations mongoOperations) {
        this.mongoOperations = mongoOperations;
    }
}
