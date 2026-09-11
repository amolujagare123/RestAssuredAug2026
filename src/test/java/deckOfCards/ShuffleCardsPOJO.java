package deckOfCards;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import POJO.DeckOfCards.ShuffleCards;

import static io.restassured.RestAssured.given;

public class ShuffleCardsPOJO {

    public static void main(String[] args) {

        RestAssured.baseURI = "https://deckofcardsapi.com";

        ShuffleCards resp = given().log().all().queryParam("deck_count", "1")
                .when().get("/api/deck/new/shuffle/")
                .then().log().all().statusCode(200).extract().as(ShuffleCards.class);

        System.out.println("id="+resp.getDeck_id());
        System.out.println("Shuffled="+resp.isShuffled());
        System.out.println("Success="+resp.isSuccess());
        System.out.println("remaining="+resp.getRemaining());


    }

}
