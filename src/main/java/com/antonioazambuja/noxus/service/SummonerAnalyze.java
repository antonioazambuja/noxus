package com.antonioazambuja.noxus.service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.antonioazambuja.noxus.resources.MatchDto;
import com.antonioazambuja.noxus.resources.MatchReferenceDto;
import com.antonioazambuja.noxus.resources.MatchlistDto;
import com.antonioazambuja.noxus.resources.SummonerDTO;

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
		Integer index = new Integer(0);
		do {
			index = index + 100;
			matchlistDto = matchService.getMatchesByAccountId(summonerDto.getAccountId(), index, index-100);
			matches.addAll(matchlistDto.getMatches());
		} while (matchlistDto.getEndIndex() == index);
		List<MatchDto> winMatches = new ArrayList<>();
		for (MatchDto matchDto: matches.stream().map(match -> matchService.getMatchById(match.getGameId()))
				.filter(match -> !match.getGameMode()
				.equals("TUTORIAL_MODULE_1"))
				.collect(Collectors.toList())) {
			Integer winTeamId = matchDto.getTeams().stream().filter(team -> team.getWin().equals("Win")).findAny().orElse(null).getTeamId();
			Integer participantIdentityDtoId = matchDto.getParticipantIdentities().stream().filter(participantIdentity -> participantIdentity.getPlayer().getAccountId().equals(summonerDto.getAccountId())).findAny().orElse(null).getParticipantId();
			Integer participantDtoTeamId = matchDto.getParticipants().stream().filter(participant -> participant.getParticipantId().equals(participantIdentityDtoId)).findAny().orElse(null).getTeamId();
			if (participantDtoTeamId.equals(winTeamId)) {
				winMatches.add(matchDto);
			}
		}
		return winMatches;
	}

	public List<MatchDto> getLoseMatchesBySummoner(String summonerName) {
		SummonerDTO summonerDto = summonerV4.getSummonerByName(summonerName);
		HashSet<MatchReferenceDto> matches = new HashSet<MatchReferenceDto>();
		MatchlistDto matchlistDto = new MatchlistDto();
		Integer index = new Integer(0);
		do {
			index = index + 100;
			matchlistDto = matchService.getMatchesByAccountId(summonerDto.getAccountId(), index, index-100);
			matches.addAll(matchlistDto.getMatches());
		} while (matchlistDto.getEndIndex() == index);
		List<MatchDto> loseMatches = new ArrayList<>();
		for (MatchDto matchDto: matches.stream().map(match -> matchService.getMatchById(match.getGameId()))
				.filter(match -> !match.getGameMode()
				.equals("TUTORIAL_MODULE_1"))
				.collect(Collectors.toList())) {
			Integer loseTeamId = matchDto.getTeams().stream().filter(team -> team.getWin().equals("Fail")).findAny().orElse(null).getTeamId();
			Integer participantIdentityDtoId = matchDto.getParticipantIdentities().stream().filter(participantIdentity -> participantIdentity.getPlayer().getAccountId().equals(summonerDto.getAccountId())).findAny().orElse(null).getParticipantId();
			Integer participantDtoTeamId = matchDto.getParticipants().stream().filter(participant -> participant.getParticipantId().equals(participantIdentityDtoId)).findAny().orElse(null).getTeamId();
			if (participantDtoTeamId.equals(loseTeamId)) {
				loseMatches.add(matchDto);
			}
		}
		return loseMatches;
	}
}
