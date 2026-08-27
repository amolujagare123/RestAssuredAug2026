package GoRest;

import io.restassured.RestAssured;

import static io.restassured.RestAssured.given;

public class CreateUser {

    public static void main(String[] args) {

        RestAssured.baseURI = "https://gorest.co.in";

        given().log().all()
                .header("Authorization","Bearer b6937dfecc6168181b06cde7d79fc22a46f97cc743642ccfe11f93ec68a310f3")
                .header("Content-type","application/json")
                .body("{ \n" +
                        " \"name\": \"Amol Ujagare\", \n" +
                        " \"email\": \"amol.ujagare@gmail.com\", \n" +
                        " \"gender\": \"male\", \n" +
                        " \"status\": \"inactive\" \n" +
                        "}")
                .when().post("/public/v2/users")
                .then().log().all().statusCode(201);
    }
}
