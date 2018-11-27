package ru.gorparkovki.MiniUniversity.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.gorparkovki.MiniUniversity.Entity.Group;
import ru.gorparkovki.MiniUniversity.Entity.Student;
import ru.gorparkovki.MiniUniversity.Repository.GroupRepository;
import ru.gorparkovki.MiniUniversity.Repository.StudentRepository;

import java.util.List;

@Service
public class GroupService {

    @Autowired
    private GroupRepository groupRepository;

    public void add(Group group) {
        groupRepository.save(group);
    }

    public Group get(String group) {
        return groupRepository.get(group);
    }
}
