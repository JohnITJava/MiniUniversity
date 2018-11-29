package ru.gorparkovki.MiniUniversity.controller;

import org.junit.Test;
import ru.gorparkovki.MiniUniversity.Entity.Group;

import java.util.HashMap;
import java.util.Map;

import com.google.common.reflect.TypeToken;
import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;
import static io.restassured.http.ContentType.JSON;
import static org.apache.http.HttpStatus.SC_OK;


/**
 * This test should test Rest method to create Group. It's NOT configure yet
 */
public class GroupControllerTest {

    @Test
    public void create() {
        //delete all groups
        Map<String, Group> firstResult = when().get("/group")
                .then().statusCode(SC_OK)
                .extract().body().as(new TypeToken<HashMap<String, Group>>() {
                }.getType());

        firstResult.keySet().forEach(id -> given().param("group", id)
                .when().delete("/group"));
        //set parameter for new groups
        final Map<String, Object> bodyAsMap = new HashMap<>();
        String expectedContent = "test";
        bodyAsMap.put("", expectedContent);
        //execute test
        Group expected = given().contentType(JSON).body(bodyAsMap).
                when().post("/group").
                then().statusCode(SC_OK).extract()
                .body().as(Group.class);
    }
}