package deckOfCards;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

import static io.restassured.RestAssured.given;

public class ShuffleCards2 {

    public static void main(String[] args) {

        RestAssured.baseURI = "https://deckofcardsapi.com";

        String respStr = given().log().all().queryParam("deck_count", "1")
                .when().get("/api/deck/new/shuffle/")
                .then().log().all().statusCode(200).extract().asString();
                /*.body("success", equalTo(true))
                .body("remaining", equalTo(52));*/


        System.out.println("respStr="+respStr);
        JsonPath jsonPath = new JsonPath(respStr);
        String deckID = jsonPath.get("deck_id");
        System.out.println("deckID="+deckID);

        given().log().all()
                .queryParam("count","2")
                .when().get("/api/deck/"+deckID+"/draw/")
                .then().log().all().statusCode(200);


    }

}
