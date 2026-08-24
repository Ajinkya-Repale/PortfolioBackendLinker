package com.MainApp.Entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "certificates")
public class Certificate {

    @Id
    private String id;

    private String title;
    private String issuer;
    private String issueDate;
    private String credentialUrl;

    public Certificate() {}

    public Certificate(String id, String title, String issuer, String issueDate, String credentialUrl) {
        this.id = id;
        this.title = title;
        this.issuer = issuer;
        this.issueDate = issueDate;
        this.credentialUrl = credentialUrl;
    }

    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public String getIssuer() { return issuer; }
    public void setIssuer(String issuer) { this.issuer = issuer; }

    public String getIssueDate() { return issueDate; }
    public void setIssueDate(String issueDate) { this.issueDate = issueDate; }

    public String getCredentialUrl() { return credentialUrl; }
    public void setCredentialUrl(String credentialUrl) { this.credentialUrl = credentialUrl; }

    @Override
    public String toString() {
        return "Certificate{id='" + id + "', title='" + title + "', issuer='" + issuer +
                "', issueDate='" + issueDate + "', credentialUrl='" + credentialUrl + "'}";
    }
}