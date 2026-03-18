package com.MainApp.Entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "About")
public class About {

    @Id
    private String id;

    private String name;
    private String role;

    private String bio1;   // paragraph 1
    private String bio2;   // paragraph 2 (optional)

    private String location;
    private String college;
    private String degree;

    // ── Constructors ──────────────────────────────────────

    public About() {}

    public About(String name, String role,
                 String bio1, String bio2,
                 String location, String college, String degree) {
        this.name     = name;
        this.role     = role;
        this.bio1     = bio1;
        this.bio2     = bio2;
        this.location = location;
        this.college  = college;
        this.degree   = degree;
    }

    // ── Getters & Setters ─────────────────────────────────

    public String getId()                    
    { 
    	return id; 
    }
    
    public void   setId(String id)
    { 
    	this.id = id; 
    }

    public String getName()                 
    { 
    	return name; 
    }
    
    public void   setName(String name)       
    { 
    	this.name = name; 
    }

    public String getRole()                  
    { 
    	return role; 
    }
    
    public void   setRole(String role)       
    { 
    	this.role = role; 
    }

    public String getBio1()                  
    { 
    	return bio1; 
    }
    
    public void   setBio1(String bio1)       
    { 
    	this.bio1 = bio1; 
    }

    public String getBio2()                  
    { 
    	return bio2; 
    }
    
    public void   setBio2(String bio2)       
    { 
    	this.bio2 = bio2; 
    }

    public String getLocation()              
    { 
    	return location; 
    }
    
    public void   setLocation(String loc)    
    { 
    	this.location = loc; 
    }

    public String getCollege()               
    { 
    	return college; 
    }
    
    public void   setCollege(String college) 
    { 
    	this.college = college; 
    }

    public String getDegree()               
    { 
    	return degree; 
    }
    
    public void   setDegree(String degree)   
    { 
    	this.degree = degree; 
    }
}