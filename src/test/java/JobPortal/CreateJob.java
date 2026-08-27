package JobPortal;

import io.restassured.RestAssured;

import static io.restassured.RestAssured.given;

public class CreateJob {

    public static void main(String[] args) {

        RestAssured.baseURI = "http://localhost:9897/";

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
                .then().log().all().statusCode(200);
    }
}
