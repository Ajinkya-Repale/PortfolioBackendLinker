package com.MainApp.Entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "education")
public class Education {

    @Id
    private String id;

    private String collegeTitle;

    private String startYear;

    private String endYear;

    private String percentage;

    // Default Constructor
    public Education() {
    }

    // Parameterized Constructor
    public Education(String id, String collegeTitle, String startYear, String endYear, String percentage) {
        this.id = id;
        this.collegeTitle = collegeTitle;
        this.startYear = startYear;
        this.endYear = endYear;
        this.percentage = percentage;
    }

    // Getters and Setters
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCollegeTitle() {
        return collegeTitle;
    }

    public void setCollegeTitle(String collegeTitle) {
        this.collegeTitle = collegeTitle;
    }

    public String getStartYear() {
        return startYear;
    }

    public void setStartYear(String startYear) {
        this.startYear = startYear;
    }

    public String getEndYear() {
        return endYear;
    }

    public void setEndYear(String endYear) {
        this.endYear = endYear;
    }

    public String getPercentage() {
        return percentage;
    }

    public void setPercentage(String percentage) {
        this.percentage = percentage;
    }

    @Override
    public String toString() {
        return "Education{" +
                "id='" + id + '\'' +
                ", collegeTitle='" + collegeTitle + '\'' +
                ", startYear='" + startYear + '\'' +
                ", endYear='" + endYear + '\'' +
                ", percentage='" + percentage + '\'' +
                '}';
    }
}