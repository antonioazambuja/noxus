package com.antonioazambuja.noxus.resources;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.fasterxml.jackson.annotation.JsonProperty;

@Repository
public class MatchFrameDto {
	@JsonProperty("participantFrames")
	private Map<String, MatchParticipantFrameDto> ParticipantFrames;
	@JsonProperty("events")
	private List<MatchEventDto> Events;
	@JsonProperty("timestamp")
	private Long Timestamp;

	public MatchFrameDto() {}

	public MatchFrameDto(Map<String, MatchParticipantFrameDto> participantFrames, List<MatchEventDto> events,
			Long timestamp) {
		ParticipantFrames = participantFrames;
		Events = events;
		Timestamp = timestamp;
	}

	public Map<String, MatchParticipantFrameDto> getParticipantFrames() {
		return ParticipantFrames;
	}

	public void setParticipantFrames(Map<String, MatchParticipantFrameDto> participantFrames) {
		ParticipantFrames = participantFrames;
	}

	public List<MatchEventDto> getEvents() {
		return Events;
	}

	public void setEvents(List<MatchEventDto> events) {
		Events = events;
	}

	public Long getTimestamp() {
		return Timestamp;
	}

	public void setTimestamp(Long timestamp) {
		Timestamp = timestamp;
	}

}
