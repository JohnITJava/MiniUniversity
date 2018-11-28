package ru.gorparkovki.MiniUniversity;

import com.google.common.reflect.TypeToken;
import ru.gorparkovki.MiniUniversity.Entity.Group;
import org.testng.annotations.Test;
import ru.gorparkovki.MiniUniversity.Entity.Student;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;
import static io.restassured.http.ContentType.JSON;
import static org.apache.http.HttpStatus.SC_OK;

public class HappyPathTest extends TestBase {

    @Test
    public void createGroupTestRest() {
        //delete all groups
        /*Map<String, Group> firstResult = when().get("/group")
                .then().statusCode(SC_OK)
                .extract().body().as(new TypeToken<HashMap<String, Group>>() {
                }.getType());
        firstResult.keySet().forEach(group -> given().param("group", group)
                .when().delete("/group"));*/

        //set parameter for new group
        final Map<String, List<Student>> bodyAsMap = new HashMap<>();
        String expectedContent = "test";
        bodyAsMap.put("content", expectedContent);
        String expectedSubtext = "some subtext";
        bodyAsMap.put("subtext", expectedSubtext);

        //execute test
        Group expected = given().contentType(JSON).body(bodyAsMap).
                when().post("/group").
                then().statusCode(SC_OK).extract()
                .body().as(Group.class);
    }

}
