package GoRest;

import io.restassured.RestAssured;

import static io.restassured.RestAssured.given;

public class UpdateUser {

    public static void main(String[] args) {

        RestAssured.baseURI = "https://gorest.co.in/";

        given().log().all()
                .header("Authorization","Bearer b6937dfecc6168181b06cde7d79fc22a46f97cc743642ccfe11f93ec68a310f3")
                .header("Content-Type","application/json")
                .body("{\n" +
                        "        \"name\": \"Amar Tulse\",\n" +
                        "        \"email\": \"amar.tulase@gmail.com\",\n" +
                        "        \"gender\": \"male\",\n" +
                        "        \"status\": \"inactive\"\n" +
                        "    }")
                .when().put("/public/v2/users/8586502")
                .then().log().all().statusCode(200);
    }
}
