package ru.gorparkovki.MiniUniversity;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import ru.gorparkovki.MiniUniversity.Entity.Group;
import ru.gorparkovki.MiniUniversity.Entity.Student;
import ru.gorparkovki.MiniUniversity.Repository.GroupRepository;

import static org.junit.Assert.assertEquals;


@DataMongoTest

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = {
        Application.class,
        TestMongoConfig.class
})
public class MongoDbSpringIntegrationTest {

    @Autowired
    private GroupRepository groupRepository;

    @Test
    public void shouldCreateGroupWithIdentittyName() {
        Group group = new Group("test", new Student("test", 5));
        groupRepository.save(group);
        assertEquals(group.getGroup(), groupRepository.getOne("test").getGroup());
    }
}