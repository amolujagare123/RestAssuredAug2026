package JobPortal;

import io.restassured.RestAssured;

import static io.restassured.RestAssured.given;

public class ListAllJob {

    public static void main(String[] args) {

        RestAssured.baseURI = "http://localhost:9897/";

        given().log().all()
                .when().get("/normal/webapi/all")
                .then().log().all().statusCode(200);
    }
}
