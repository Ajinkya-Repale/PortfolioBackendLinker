package com.MainApp.Entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Skills") // corrected from 'collation' to 'collection'
public class Skills {

    @Id
    private String id;           // MongoDB document ID

    private String group;        // e.g., "Frontend", "Backend", "Tools"
    private String name;         // e.g., "React"
    private String icon;         // e.g., "FaReact"

    
    public Skills() {}

    // Parameterized constructor
    public Skills(String group, String name, String icon) {
        this.group = group;
        this.name = name;
        this.icon = icon;
    }

    // Getters and Setters
    public String getId()
    { 
    	return id; 
    }
    
    public void setId(String id) 
    { 
    	this.id = id; 
    }
    

    public String getGroup() 
    { 
    	return group; 
    }
    
    public void setGroup(String group) 
    { 
    	this.group = group; 
    }
    

    public String getName() 
    { 
    	return name; 
    }
    
    public void setName(String name) 
    { 
    	this.name = name;
    }

    public String getIcon() 
    { 
    	return icon; 
    }
    
    public void setIcon(String icon) 
    { 
    	this.icon = icon; 
    }

    @Override
    public String toString() {
        return "Skills{" +
                "id='" + id + '\'' +
                ", group='" + group + '\'' +
                ", name='" + name + '\'' +
                ", icon='" + icon + '\'' +
                '}';
    }
}