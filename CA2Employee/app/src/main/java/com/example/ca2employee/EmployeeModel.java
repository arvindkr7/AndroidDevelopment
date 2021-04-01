package com.example.ca2employee;

public class EmployeeModel {
    private int image;
    private String name, jobTitle;

    public EmployeeModel(int image, String name, String jobTitle) {
        this.image = image;
        this.name = name;
        this.jobTitle = jobTitle;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }
}
