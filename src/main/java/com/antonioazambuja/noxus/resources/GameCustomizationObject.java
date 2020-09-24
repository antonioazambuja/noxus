package com.antonioazambuja.noxus.resources;

import org.springframework.stereotype.Repository;

import com.fasterxml.jackson.annotation.JsonProperty;

@Repository
public class GameCustomizationObject {
	@JsonProperty("category")
	private String Category;
	@JsonProperty("content")
	private String Content;

	public GameCustomizationObject() {}

	public GameCustomizationObject(String category, String content) {
		Category = category;
		Content = content;
	}

	public String getCategory() {
		return Category;
	}

	public void setCategory(String category) {
		Category = category;
	}

	public String getContent() {
		return Content;
	}

	public void setContent(String content) {
		Content = content;
	}
}
