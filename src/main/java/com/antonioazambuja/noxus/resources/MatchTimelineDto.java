package com.antonioazambuja.noxus.resources;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.fasterxml.jackson.annotation.JsonProperty;

@Repository
public class MatchTimelineDto {
	@JsonProperty("frames")
	private List<MatchFrameDto> Frames;
	@JsonProperty("frameInterval")
	private Long FrameInterval;

	public MatchTimelineDto() {}

	public MatchTimelineDto(List<MatchFrameDto> frames, Long frameInterval) {
		Frames = frames;
		FrameInterval = frameInterval;
	}

	public List<MatchFrameDto> getFrames() {
		return Frames;
	}

	public void setFrames(List<MatchFrameDto> frames) {
		Frames = frames;
	}

	public Long getFrameInterval() {
		return FrameInterval;
	}

	public void setFrameInterval(Long frameInterval) {
		FrameInterval = frameInterval;
	}

}
