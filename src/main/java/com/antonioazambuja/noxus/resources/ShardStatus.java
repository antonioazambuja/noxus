package com.antonioazambuja.noxus.resources;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.fasterxml.jackson.annotation.JsonProperty;

@Repository
public class ShardStatus {
	@JsonProperty("locales")
	private List<String> Locales;
	@JsonProperty("hostname")
	private String Hostname;
	@JsonProperty("name")
	private String Name;
	@JsonProperty("services")
	private List<Service> Services;
	@JsonProperty("slug")
	private String Slug;
	@JsonProperty("region_tag")
	private String Region_Tag;

	public ShardStatus() {}

	public ShardStatus(List<String> locales, String hostname, String name, List<Service> services, String slug,
			String region_Tag) {
		Locales = locales;
		Hostname = hostname;
		Name = name;
		Services = services;
		Slug = slug;
		Region_Tag = region_Tag;
	}

	public List<String> getLocales() {
		return Locales;
	}

	public void setLocales(List<String> locales) {
		Locales = locales;
	}

	public String getHostname() {
		return Hostname;
	}

	public void setHostname(String hostname) {
		Hostname = hostname;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public List<Service> getServices() {
		return Services;
	}

	public void setServices(List<Service> services) {
		Services = services;
	}

	public String getSlug() {
		return Slug;
	}

	public void setSlug(String slug) {
		Slug = slug;
	}

	public String getRegion_Tag() {
		return Region_Tag;
	}

	public void setRegion_Tag(String region_Tag) {
		Region_Tag = region_Tag;
	}

}
