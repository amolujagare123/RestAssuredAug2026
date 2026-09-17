package GoRest;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

import static io.restassured.RestAssured.given;

public class CreateUserSpecBuilder {

    public static void main(String[] args) {

       /* RestAssured.baseURI = "https://gorest.co.in";

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
                .then().log().all().statusCode(201);*/


        RequestSpecification requestSpec = new RequestSpecBuilder()
                .setBaseUri("https://gorest.co.in")
                .addHeader("Authorization","Bearer b6937dfecc6168181b06cde7d79fc22a46f97cc743642ccfe11f93ec68a310f3")
                .addHeader("Content-type","application/json")
                .build();

        RequestSpecification request = given().log().all().spec(requestSpec).body("{ \n" +
                " \"name\": \"Amol Ujagare\", \n" +
                " \"email\": \"amol.ujagare1@gmail.com\", \n" +
                " \"gender\": \"male\", \n" +
                " \"status\": \"inactive\" \n" +
                "}");

        Response response = request.when().post("/public/v2/users");

        ResponseSpecification responseSpec = new ResponseSpecBuilder()
                .expectStatusCode(201).build();

        String respStr = response.then().log().all().spec(responseSpec).extract().asString();

        System.out.println(respStr);

    }
}
