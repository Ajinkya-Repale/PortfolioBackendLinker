package com.MainApp.Entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document(collection = "projects")
public class Projects {

    @Id
    private String id;  // <- make sure _id is a String

    private String title;
    private String description;  // fix typo here
    private List<String> tech;   // instead of techStack string
    private String liveDemo;
    private String github;
    private String image;

    // getters and setters
    public String getId() 
    { 
    	return id; 
    }
    
    public void setId(String id) 
    { 
    	this.id = id; 
    }

    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public List<String> getTech() { return tech; }
    public void setTech(List<String> tech) { this.tech = tech; }

    public String getLiveDemo() { return liveDemo; }
    public void setLiveDemo(String liveDemo) { this.liveDemo = liveDemo; }

    public String getGithub() { return github; }
    public void setGithub(String github) { this.github = github; }

    public String getImage() { return image; }
    public void setImage(String image) { this.image = image; }
}