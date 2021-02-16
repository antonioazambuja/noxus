package com.github.antonioazambuja.noxus.resources;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Message {
	@JsonProperty("id")
	private String Id;
	@JsonProperty("author")
	private String Author;
	@JsonProperty("heading")
	private String Heading;
	@JsonProperty("content")
	private String Content;
	@JsonProperty("severity")
	private String Severity;
	@JsonProperty("created_at")
	private String Created_At;
	@JsonProperty("updated_at")
	private String Updated_At;
	@JsonProperty("translations")
	private List<Translation> Translations;

	public Message() {}

	public Message(String id, String author, String heading, String content, String severity, String created_At,
			String updated_At, List<Translation> translations) {
		Id = id;
		Author = author;
		Heading = heading;
		Content = content;
		Severity = severity;
		Created_At = created_At;
		Updated_At = updated_At;
		Translations = translations;
	}

	public String getId() {
		return Id;
	}

	public void setId(String id) {
		Id = id;
	}

	public String getAuthor() {
		return Author;
	}

	public void setAuthor(String author) {
		Author = author;
	}

	public String getHeading() {
		return Heading;
	}

	public void setHeading(String heading) {
		Heading = heading;
	}

	public String getContent() {
		return Content;
	}

	public void setContent(String content) {
		Content = content;
	}

	public String getSeverity() {
		return Severity;
	}

	public void setSeverity(String severity) {
		Severity = severity;
	}

	public String getCreated_At() {
		return Created_At;
	}

	public void setCreated_At(String created_At) {
		Created_At = created_At;
	}

	public String getUpdated_At() {
		return Updated_At;
	}

	public void setUpdated_At(String updated_At) {
		Updated_At = updated_At;
	}

	public List<Translation> getTranslations() {
		return Translations;
	}

	public void setTranslations(List<Translation> translations) {
		Translations = translations;
	}

}
