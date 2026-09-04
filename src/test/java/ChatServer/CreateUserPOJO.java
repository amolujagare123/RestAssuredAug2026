package ChatServer;

import POJO.ChatServer.CreateUser;
import io.restassured.RestAssured;

import java.util.ArrayList;

import static io.restassured.RestAssured.given;

public class CreateUserPOJO {

    public static void main(String[] args) {

        RestAssured.baseURI = "https://demo.livehelperchat.com/site_admin";


        CreateUser createUser = new CreateUser();
        createUser.setUsername("amolujagare");
        createUser.setPassword("amol1234");
        createUser.setName("Amol");
        createUser.setSurname("Ujagare");
        createUser.setEmail("amol@gmail.com");
        createUser.setChat_Nickname("amol123");

        ArrayList<Integer> dept = new ArrayList<>();
        dept.add(1);
        dept.add(2);

        createUser.setDepartments(dept);

        ArrayList<Integer> deptRead = new ArrayList<>();
        deptRead.add(2);

        createUser.setDepartments_read(deptRead);

        ArrayList<Integer> groups = new ArrayList<>();
        groups.add(1);

        createUser.setDepartment_groups(groups);
        createUser.setUser_groups(groups);

        given().log().all()
                .header("Content-Type","application/json")
                .auth().preemptive().basic("admin","demo")
                .body(createUser)
                .when().post("/restapi/user")
                .then().log().all().statusCode(200);

    }
}
