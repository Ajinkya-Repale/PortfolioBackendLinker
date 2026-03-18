package com.MainApp.Entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "heros")
public class Hero {

	@Id
	private String id;
	
	private String introText;
	
	private String HeroTitle;
	
	private String HeroDescription;
	
	private String name;
	
	private String role;
	
	private String avatarUrl;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getIntroText() {
		return introText;
	}

	public void setIntroText(String introText) {
		this.introText = introText;
	}

	public String getHeroTitle() {
		return HeroTitle;
	}

	public void setHeroTitle(String heroTitle) {
		HeroTitle = heroTitle;
	}

	public String getHeroDescription() {
		return HeroDescription;
	}

	public void setHeroDescription(String heroDescription) {
		HeroDescription = heroDescription;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getAvatarUrl() {
		return avatarUrl;
	}

	public void setAvatarUrl(String avatarUrl) {
		this.avatarUrl = avatarUrl;
	}
	
	
	
	
}
