package com.antonioazambuja.noxus.controller;

import java.util.HashSet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.antonioazambuja.noxus.resources.MatchDto;
import com.antonioazambuja.noxus.resources.MatchTimelineDto;
import com.antonioazambuja.noxus.resources.MatchlistDto;
import com.antonioazambuja.noxus.service.MatchV4;

@RestController
public class MatchV4Controller {

	@Autowired
	private MatchV4 matchV4;

	@RequestMapping("/match/{matchId}")
	public MatchDto getMatchById(@PathVariable(value="matchId") String matchId) {
		return matchV4.getMatchById(matchId);
	}

	@RequestMapping("/match/{matchId}")
	public MatchTimelineDto getMatchTimelineById(@PathVariable(value="matchId") String matchId) {
		return matchV4.getTimelineMatchById(matchId);
	}

	@RequestMapping("/matches/{encryptedAccountId}")
	public MatchlistDto getMatchlistByAccountId(
			@PathVariable(value="encryptedAccountId") String encryptedAccountId,
			@RequestParam(name = "champion", required = false, defaultValue = "") HashSet<Integer> champion,
			@RequestParam(name = "queue", required = false, defaultValue = "") HashSet<Integer> queue,
			@RequestParam(name = "season", required = false, defaultValue = "") HashSet<Integer> season,
			@RequestParam(name = "endTime", required = false, defaultValue = "") Long endTime,
			@RequestParam(name = "beginTime", required = false, defaultValue = "") Long beginTime,
			@RequestParam(name = "endIndex", required = false, defaultValue = "") Integer endIndex,
			@RequestParam(name = "beginIndex", required = false, defaultValue = "") Integer beginIndex
			) {
		return matchV4.getMatchesByAccountId(encryptedAccountId, champion, queue, season, endTime, beginTime, endIndex, beginIndex);
	}

}
