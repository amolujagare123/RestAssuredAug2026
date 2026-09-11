package JobPortal;

import POJO.JobPortal.CreateJob;
import POJO.JobPortal.Project;
import io.restassured.RestAssured;

import java.util.ArrayList;
import java.util.Arrays;

import static io.restassured.RestAssured.given;

public class CreateJobPOJO2 {

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


        CreateJob createJob1 = given().log().all()
                .header("Content-Type", "application/json")
                .header("Accept", "application/json")
                .body(createJob)
                .when().post("/normal/webapi/add")
                .then().log().all().statusCode(201).extract().as(CreateJob.class);


        // get job title
        String jobTitle = createJob1.getJobTitle();
        System.out.println("jobTitle="+jobTitle);

        // get job description
        String description = createJob1.getJobDescription();
        System.out.println("Job description="+description);

        // print all experience values

        for(int i=0 ;i < createJob1.getExperience().size() ;i++)
            System.out.println(createJob1.getExperience().get(i));

        // print project name of 2nd project
        String projectName = createJob1.getProject().get(1).getProjectName();
        System.out.println("projectName="+projectName);


        // print all technologies of 1st project

        for(int i=0 ;i < createJob1.getProject().get(0).getTechnology().size() ;i++)
            System.out.println(createJob1.getProject().get(0).getTechnology().get(i));


       // print 3rd technology of 2nd project

        System.out.println(createJob1.getProject().get(1).getTechnology().get(2));




    }
}
