package deckOfCards;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSender;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.responseSpecification;

public class ShuffleCardsSpecBuilder {

    public static void main(String[] args) {

      //  RestAssured.baseURI = "https://deckofcardsapi.com";

     /*   String respStr = given().log().all().queryParam("deck_count", "1")
                .when().get("/api/deck/new/shuffle/")
                .then().log().all().statusCode(200).extract().asString();*/

        // 1. create object of Request specification using  RequestSpecBuilder

        RequestSpecification requestSpecification = new RequestSpecBuilder()
                .setBaseUri("https://deckofcardsapi.com")
                .addQueryParam("deck_count", "1")
                .build();

        //2 . get the request return by calling given method , here we are passing  the request specification object
        RequestSpecification request = given().log().all().spec(requestSpecification);

        // 3. using request object we are calling when followed my the resource as per the method ( get/post/put/delete)
        Response resource = request.when().get("/api/deck/new/shuffle/");

        // 4. create Response specification object for then part
        ResponseSpecification responseSpecification = new ResponseSpecBuilder()
                .expectStatusCode(200).build();

        // 5. we are calling then method using resource object
        String respStr = resource.then().log().all().spec(responseSpecification).extract().asString();

        System.out.println(respStr);

    }

}
