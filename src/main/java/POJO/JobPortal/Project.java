package POJO.JobPortal;

import java.util.List;

public class Project {

    String projectName;
    List<String> technology;

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public List<String> getTechnology() {
        return technology;
    }

    public void setTechnology(List<String> technology) {
        this.technology = technology;
    }
}
