package com.github.antonioazambuja.noxus.resources;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Perks {
	@JsonProperty("perkIds")
	private List<Long> PerkIds;
	@JsonProperty("perkStyle")
	private Long PerkStyle;
	@JsonProperty("perkSubStyle")
	private Long PerkSubStyle;

	public Perks() {}

	public Perks(List<Long> perkIds, Long perkStyle, Long perkSubStyle) {
		PerkIds = perkIds;
		PerkStyle = perkStyle;
		PerkSubStyle = perkSubStyle;
	}

	public List<Long> getPerkIds() {
		return PerkIds;
	}

	public void setPerkIds(List<Long> perkIds) {
		PerkIds = perkIds;
	}

	public Long getPerkStyle() {
		return PerkStyle;
	}

	public void setPerkStyle(Long perkStyle) {
		PerkStyle = perkStyle;
	}

	public Long getPerkSubStyle() {
		return PerkSubStyle;
	}

	public void setPerkSubStyle(Long perkSubStyle) {
		PerkSubStyle = perkSubStyle;
	}
}
