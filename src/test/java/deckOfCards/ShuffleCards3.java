package deckOfCards;

import POJO.DeckOfCards.Deck;
import POJO.DeckOfCards.DrawCards;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

import static io.restassured.RestAssured.given;

public class ShuffleCards3 {

    public static void main(String[] args) {

        RestAssured.baseURI = "https://deckofcardsapi.com";

        Deck deck = given().log().all().queryParam("deck_count", "1")
                .when().get("/api/deck/new/shuffle/")
                .then().log().all().statusCode(200).extract().as(Deck.class);

        System.out.println("id="+deck.getDeck_id());
        System.out.println("shuffled="+deck.isShuffled());
        System.out.println("success="+deck.isSuccess());
        System.out.println("remaining="+deck.getRemaining());


        DrawCards drawCards = given().log().all()
                .queryParam("count", "2")
                .when().get("/api/deck/" + deck.getDeck_id() + "/draw/")
                .then().log().all().statusCode(200).extract().as(DrawCards.class);

        // get value of card 1
        String value = drawCards.getCards().get(0).getValue();
        System.out.println("value="+value);
        // get svg url of image 2

        String svg = drawCards.getCards().get(1).getImages().getSvg();
        System.out.println("svg="+svg);

        // get code of card 1
        String code = drawCards.getCards().get(0).getCode();
        System.out.println("code="+code);

        // get suit of card 2
        String suit = drawCards.getCards().get(1).getSuit();
        System.out.println("suit="+suit);







    }

}
