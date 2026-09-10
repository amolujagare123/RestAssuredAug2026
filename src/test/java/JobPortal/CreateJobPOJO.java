package JobPortal;

import POJO.JobPortal.CreateJob;
import POJO.JobPortal.Project;
import io.restassured.RestAssured;

import java.util.ArrayList;
import java.util.Arrays;

import static io.restassured.RestAssured.given;

public class CreateJobPOJO {

    public static void main(String[] args) {

        RestAssured.baseURI = "http://localhost:9897/";

        CreateJob createJob = new CreateJob();

        ArrayList<String> exp = new ArrayList<>();
        exp.add("IBM");
        exp.add("Zensar");
        exp.add("TCS");

        createJob.setExperience(exp);

      //  createJob.setExperience(Arrays.asList("IBM", "Zensar", "TCS"));
        createJob.setJobDescription("Automation testing with API and playwright");
        createJob.setJobId(2);
        createJob.setJobTitle("Senior automation test Engineer");


        Project project1 = new Project();

        project1.setProjectName("HRMS");
        project1.setTechnology(Arrays.asList("Java","SQL","Selenium"));


        Project project2 = new Project();
        project2.setProjectName("Stock MS");
        project2.setTechnology(Arrays.asList(".Net","MS-SQL","Playwright"));


        createJob.setProject(Arrays.asList(project1,project2));





        given().log().all()
                .header("Content-Type","application/json")
                .header("Accept","application/json")
                .body(createJob)
                .when().post("/normal/webapi/add")
                .then().log().all().statusCode(200);
    }
}
