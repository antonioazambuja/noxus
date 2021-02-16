package com.github.antonioazambuja.noxus.resources;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Incident {
	@JsonProperty("id")
	private Long Id;
	@JsonProperty("active")
	private Boolean Active;
	@JsonProperty("created_at")
	private String Created_At;
	@JsonProperty("updates")
	private List<Message> Updates;

	public Incident() {}

	public Incident(Long id, Boolean active, String created_At, List<Message> updates) {
		Id = id;
		Active = active;
		Created_At = created_At;
		Updates = updates;
	}

	public Long getId() {
		return Id;
	}

	public void setId(Long id) {
		Id = id;
	}

	public Boolean getActive() {
		return Active;
	}

	public void setActive(Boolean active) {
		Active = active;
	}

	public String getCreated_At() {
		return Created_At;
	}

	public void setCreated_At(String created_At) {
		Created_At = created_At;
	}

	public List<Message> getUpdates() {
		return Updates;
	}

	public void setUpdates(List<Message> updates) {
		Updates = updates;
	}

}
