package JobPortal;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.response.Response;
import io.restassured.specification.RequestSender;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

import static io.restassured.RestAssured.given;

public class CreateJobSpecBuilder {

    public static void main(String[] args) {

       /* RestAssured.baseURI = "http://localhost:9897/";

        given().log().all()
                .header("Content-Type","application/json")
                .body(" {\n" +
                        "        \"jobId\": 2,\n" +
                        "        \"jobTitle\": \"Software Automation Testing\",\n" +
                        "        \"jobDescription\": \"5 Years experience in UI & API Testing\",\n" +
                        "        \"experience\": [\n" +
                        "            \"Selenium\",\n" +
                        "            \"Java\",\n" +
                        "            \"Rest Assured\"\n" +
                        "        ],\n" +
                        "        \"project\": [\n" +
                        "            {\n" +
                        "                \"projectName\": \"HRMS\",\n" +
                        "                \"technology\": [\n" +
                        "                    \"Java\",\n" +
                        "                    \"SQL Lite\"\n" +
                        "                 ]\n" +
                        "            }\n" +
                        "        ]\n" +
                        "    }")
                .when().post("/normal/webapi/add")
                .then().log().all().statusCode(200);*/

        RequestSpecification requestSpec = new RequestSpecBuilder()
                .setBaseUri("http://localhost:9897/")
                .setAccept("application/json")
                .setContentType("application/json")
                .build();

        RequestSpecification request = given().log().all().spec(requestSpec).body(" {\n" +
                "        \"jobId\": 2,\n" +
                "        \"jobTitle\": \"Software Automation Testing\",\n" +
                "        \"jobDescription\": \"5 Years experience in UI & API Testing\",\n" +
                "        \"experience\": [\n" +
                "            \"Selenium\",\n" +
                "            \"Java\",\n" +
                "            \"Rest Assured\"\n" +
                "        ],\n" +
                "        \"project\": [\n" +
                "            {\n" +
                "                \"projectName\": \"HRMS\",\n" +
                "                \"technology\": [\n" +
                "                    \"Java\",\n" +
                "                    \"SQL Lite\"\n" +
                "                 ]\n" +
                "            }\n" +
                "        ]\n" +
                "    }");

        Response response = request.when().post("/normal/webapi/add");

        ResponseSpecification responseSpec = new ResponseSpecBuilder()
                .expectStatusCode(201).build();

        String respStr = response.then().log().all().spec(responseSpec).extract().asString();

        System.out.println(respStr);
    }
}
