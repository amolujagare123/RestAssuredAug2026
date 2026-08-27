package ChatServer;

import io.restassured.RestAssured;

import static io.restassured.RestAssured.given;
import static payload.ChatServerPayload.ChatServerUserPayload.getChatServerUserPayload;

public class GetAllUsers {

    public static void main(String[] args) {

        RestAssured.baseURI = "https://demo.livehelperchat.com/site_admin";

        given().log().all()
                .header("Content-Type","application/json")
                .auth().preemptive().basic("admin","demo")
                 .when().get("/restapi/getusers")
                .then().log().all().statusCode(200);

    }
}
