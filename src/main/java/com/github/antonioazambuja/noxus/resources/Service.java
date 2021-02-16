package com.github.antonioazambuja.noxus.resources;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Service {
	@JsonProperty("name")
	private String Name;
	@JsonProperty("slug")
	private String Slug;
	@JsonProperty("status")
	private String Status;
	@JsonProperty("incidents")
	private List<Incident> Incidents;

	public Service() {}

	public Service(String name, String slug, String status, List<Incident> incidents) {
		Name = name;
		Slug = slug;
		Status = status;
		Incidents = incidents;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public String getSlug() {
		return Slug;
	}

	public void setSlug(String slug) {
		Slug = slug;
	}

	public String getStatus() {
		return Status;
	}

	public void setStatus(String status) {
		Status = status;
	}

	public List<Incident> getIncidents() {
		return Incidents;
	}

	public void setIncidents(List<Incident> incidents) {
		Incidents = incidents;
	}

}
