package com.MainApp.Entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Footer")
public class Footer {

    @Id
    private String id;

    private String linkedinUrl;
    private String githubUrl;
    private String email;

    // ── Constructors ──────────────────────────────────────

    public Footer() {}

    public Footer(String linkedinUrl, String githubUrl, String email) {
        this.linkedinUrl = linkedinUrl;
        this.githubUrl   = githubUrl;
        this.email       = email;
    }

    // ── Getters & Setters ─────────────────────────────────

    public String getId()
    {
        return id;
    }

    public void setId(String id)
    {
        this.id = id;
    }

    public String getLinkedinUrl()
    {
        return linkedinUrl;
    }

    public void setLinkedinUrl(String linkedinUrl)
    {
        this.linkedinUrl = linkedinUrl;
    }

    public String getGithubUrl()
    {
        return githubUrl;
    }

    public void setGithubUrl(String githubUrl)
    {
        this.githubUrl = githubUrl;
    }

    public String getEmail()
    {
        return email;
    }

    public void setEmail(String email)
    {
        this.email = email;
    }
}