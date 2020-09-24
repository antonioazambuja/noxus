package com.antonioazambuja.noxus.resources;

import org.springframework.stereotype.Repository;

import com.fasterxml.jackson.annotation.JsonProperty;

@Repository
public class Translation {
	@JsonProperty("updated_at")
	private String Updated_At;
	@JsonProperty("locale")
	private String Locale;
	@JsonProperty("content")
	private String Content;

	public Translation() {}

	public Translation(String updated_At, String locale, String content) {
		this.Updated_At = updated_At;
		this.Locale = locale;
		this.Content = content;
	}

	public String getUpdated_At() {
		return this.Updated_At;
	}

	public void setUpdated_At(String updated_At) {
		this.Updated_At = updated_At;
	}

	public String getLocale() {
		return this.Locale;
	}

	public void setLocale(String locale) {
		this.Locale = locale;
	}

	public String getContent() {
		return this.Content;
	}

	public void setContent(String content) {
		this.Content = content;
	}
}
