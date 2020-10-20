package com.antonioazambuja.noxus.service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.antonioazambuja.noxus.resources.MatchDto;
import com.antonioazambuja.noxus.resources.MatchReferenceDto;
import com.antonioazambuja.noxus.resources.MatchlistDto;
import com.antonioazambuja.noxus.resources.ParticipantDto;
import com.antonioazambuja.noxus.resources.ParticipantIdentityDto;
import com.antonioazambuja.noxus.resources.SummonerDTO;
import com.antonioazambuja.noxus.resources.TeamStatsDto;

@Service
public class SummonerAnalyze {

	@Autowired
	private SummonerV4Service summonerV4;

	@Autowired
	private MatchV4Service matchService;

	public List<MatchDto> getWinMatchesBySummoner(String summonerName) {
		SummonerDTO summonerDto = summonerV4.getSummonerByName(summonerName);
		HashSet<MatchReferenceDto> matches = new HashSet<MatchReferenceDto>();
		MatchlistDto matchlistDto = new MatchlistDto();
		do {
			matchlistDto = matchService.getMatchesByAccountId(summonerDto.getAccountId(), 100, 0);
			matches.addAll(matchlistDto.getMatches());
		} while (matchlistDto.getEndIndex() != 100);
		List<MatchDto> winMatches = new ArrayList<>();
		for (MatchReferenceDto matchReferenceDto: matches) {
			MatchDto matchDto = matchService.getMatchById(matchReferenceDto.getGameId());
			TeamStatsDto winTeam = matchDto.getTeams().stream().filter(team -> team.getWin().equals("Win")).findAny().orElse(null);
			ParticipantIdentityDto participantIdentityDto = matchDto.getParticipantIdentities().stream().filter(participantIdentity -> participantIdentity.getPlayer().getAccountId().equals(summonerDto.getAccountId())).findAny().orElse(null);
			ParticipantDto participantDto = matchDto.getParticipants().stream().filter(participant -> participant.getParticipantId().equals(participantIdentityDto.getParticipantId())).findAny().orElse(null);
			if (participantDto.getTeamId() == winTeam.getTeamId()) {
				winMatches.add(matchDto);
			}
		}
		return winMatches;
	}
}
