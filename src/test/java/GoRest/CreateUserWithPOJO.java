package GoRest;

import POJO.GoRest.CreateUser;
import io.restassured.RestAssured;
import org.hamcrest.Matchers;

import static io.restassured.RestAssured.given;
import static payload.GoRestPayload.GoRestCreateUpdateUser.getCreateUserPayload;

public class CreateUserWithPOJO {

    public static void main(String[] args) {

        RestAssured.baseURI = "https://gorest.co.in";

        CreateUser createUser = new CreateUser();
        createUser.setName("vaishali gadekar");
        createUser.setEmail("vaishali2@gmail.com");
        createUser.setGender("female");
        createUser.setStatus("active");

        given().log().all()
                .header("Authorization","Bearer b6937dfecc6168181b06cde7d79fc22a46f97cc743642ccfe11f93ec68a310f3")
                .header("Content-type","application/json")
               // .body(getCreateUserPayload())
                .body(createUser)
                .when().post("/public/v2/users")
                .then().log().all().statusCode(201)
                .time(Matchers.lessThan(1000l));
    }
}
