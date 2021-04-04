package com.example.ca2employee;

import android.net.Uri;

public class EmployeeModel {
    private int image;
    private Uri imageUri;
    private String name, jobTitle;

    public EmployeeModel(int image, String name, String jobTitle) {
        this.image = image;
        this.name = name;
        this.jobTitle = jobTitle;
    }
    public EmployeeModel(Uri imageUri, String name, String jobTitle) {
        this.imageUri = imageUri;
        this.name = name;
        this.jobTitle = jobTitle;
    }



    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public Uri getImageUri() { return imageUri; }

    public void setImageUri(Uri imageUri) { this.imageUri = imageUri;}

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
