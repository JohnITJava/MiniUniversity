package ru.gorparkovki.MiniUniversity.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.gorparkovki.MiniUniversity.Entity.Group;
import ru.gorparkovki.MiniUniversity.Entity.Teacher;
import ru.gorparkovki.MiniUniversity.Repository.GroupRepository;
import ru.gorparkovki.MiniUniversity.Repository.TeacherRepository;

import java.util.List;

@Service
public class TeacherService {

    @Autowired
    private TeacherRepository teacherRepository;

    @Autowired
    GroupService groupService;

    public void add(Teacher teacher) {
        groupService.getByName(teacher.getGroup()).forEach(group ->
                groupService.updateTeacher(group, teacher.getTeacher()));
        teacherRepository.save(teacher);
    }

    public List<Group> getGroupByTeacher(String teacherName){
        return groupService.getByTeacher(teacherName);
    }

    public Teacher get(String teacher) {
        return teacherRepository.get(teacher);
    }
}
