package ChatServer;

import io.restassured.RestAssured;

import static io.restassured.RestAssured.given;
import static payload.ChatServerPayload.ChatServerUserPayload.getChatServerUserPayload;

public class CreateUser {

    public static void main(String[] args) {

        RestAssured.baseURI = "https://demo.livehelperchat.com/site_admin";

        given().log().all()
                .header("Content-Type","application/json")
                .auth().preemptive().basic("admin","demo")
                .body(getChatServerUserPayload("rajesh.kumar", "password", "rajesh.kumar@example.in", "Rajesh", "Kumar", "Raj"))
                .when().post("/restapi/user")
                .then().log().all().statusCode(200);

    }
}
