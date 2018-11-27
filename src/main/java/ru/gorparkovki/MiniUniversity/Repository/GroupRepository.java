package ru.gorparkovki.MiniUniversity.Repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;
import ru.gorparkovki.MiniUniversity.Entity.Group;


@Repository
public class GroupRepository {

    @Autowired
    private MongoOperations mongoOperations;

    public void save(Group group) {
        mongoOperations.save(group);
    }

    public Group get(String group) {
        return mongoOperations.findOne(Query.query(Criteria.where("group").is(group)), Group.class);
    }


}
