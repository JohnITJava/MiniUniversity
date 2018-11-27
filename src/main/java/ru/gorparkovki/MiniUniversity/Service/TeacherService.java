package ru.gorparkovki.MiniUniversity.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.gorparkovki.MiniUniversity.Entity.Group;
import ru.gorparkovki.MiniUniversity.Repository.GroupRepository;

@Service
public class TeacherService {

    @Autowired
    private GroupRepository groupRepository;

    public void add(Group group) {
        groupRepository.save(group);
    }

    public Group get(String group) {
        return groupRepository.get(group);
    }
}
