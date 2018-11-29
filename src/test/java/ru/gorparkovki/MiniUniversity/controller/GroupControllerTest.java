package ru.gorparkovki.MiniUniversity.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import ru.gorparkovki.MiniUniversity.Entity.Group;
import ru.gorparkovki.MiniUniversity.Entity.Student;

import java.util.*;

import static java.util.Collections.singletonList;
import static javax.servlet.http.HttpServletResponse.SC_OK;
import static javax.xml.transform.OutputKeys.VERSION;
import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import static org.hamcrest.core.Is.is;
import static org.mockito.BDDMockito.given;
import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@WebMvcTest(GroupController.class)
public class GroupControllerTest {

    @Autowired
    private MockMvc mvc;

    @MockBean
    private GroupController groupController;

    @Test
    public void getGroupByName() throws Exception {
        Group group = new Group();
        group.setGroup("test");
        group.setStudents(new ArrayList<>(Arrays.asList(new Student("test", 0))));

        given(groupController.read(group.getGroup())).willReturn((List<Student>) group);

        mvc.perform(get("group/" + group.getGroup())
                .contentType(APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("test", is(group.getGroup())));
    }
}