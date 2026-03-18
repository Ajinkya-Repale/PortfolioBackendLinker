package com.MainApp.Entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "contact")
public class Contact {

    @Id
    private String id;

    // Left side content
    private String header;        
    private String description;   
    private String email;         
    private String location;      
    private String availability;  

    // Form content
    private String formYourName;
    private String formYourEmail;
    private String formYourMessage;

    // Social / icon links
    private String githubUrl;
    private String linkedInUrl;
    private String emailUrl;

    // Default Constructor
    public Contact() {}

    // Parameterized Constructor
    public Contact(String header, String description, String email, String location, String availability,
                   String formYourName, String formYourEmail, String formYourMessage,
                   String githubUrl, String linkedInUrl, String emailUrl) {

        this.header = header;
        this.description = description;
        this.email = email;
        this.location = location;
        this.availability = availability;
        this.formYourName = formYourName;
        this.formYourEmail = formYourEmail;
        this.formYourMessage = formYourMessage;
        this.githubUrl = githubUrl;
        this.linkedInUrl = linkedInUrl;
        this.emailUrl = emailUrl;
    }

    // Getters and Setters

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getHeader() {
        return header;
    }

    public void setHeader(String header) {
        this.header = header;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getAvailability() {
        return availability;
    }

    public void setAvailability(String availability) {
        this.availability = availability;
    }

    public String getFormYourName() {
        return formYourName;
    }

    public void setFormYourName(String formYourName) {
        this.formYourName = formYourName;
    }

    public String getFormYourEmail() {
        return formYourEmail;
    }

    public void setFormYourEmail(String formYourEmail) {
        this.formYourEmail = formYourEmail;
    }

    public String getFormYourMessage() {
        return formYourMessage;
    }

    public void setFormYourMessage(String formYourMessage) {
        this.formYourMessage = formYourMessage;
    }

    public String getGithubUrl() {
        return githubUrl;
    }

    public void setGithubUrl(String githubUrl) {
        this.githubUrl = githubUrl;
    }

    public String getLinkedInUrl() {
        return linkedInUrl;
    }

    public void setLinkedInUrl(String linkedInUrl) {
        this.linkedInUrl = linkedInUrl;
    }

    public String getEmailUrl() {
        return emailUrl;
    }

    public void setEmailUrl(String emailUrl) {
        this.emailUrl = emailUrl;
    }
}