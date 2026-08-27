package GoRest;

import io.restassured.RestAssured;
import org.hamcrest.Matchers;

import static io.restassured.RestAssured.given;
import static payload.GoRestPayload.GoRestCreateUpdateUser.getCreateUserPayload;

public class CreateUserWithPayload {

    public static void main(String[] args) {

        RestAssured.baseURI = "https://gorest.co.in";

        given().log().all()
                .header("Authorization","Bearer b6937dfecc6168181b06cde7d79fc22a46f97cc743642ccfe11f93ec68a310f3")
                .header("Content-type","application/json")
               // .body(getCreateUserPayload())
                .body(getCreateUserPayload("vaishali gadekar","vaishali@gmail.com","female","active"))
                .when().post("/public/v2/users")
                .then().log().all().statusCode(201)
                .time(Matchers.lessThan(1000l));
    }
}
