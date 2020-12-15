package com.antonioazambuja.noxus.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.antonioazambuja.noxus.resources.MatchDto;
import com.antonioazambuja.noxus.resources.MatchReferenceDto;
import com.antonioazambuja.noxus.resources.MatchlistDto;
import com.antonioazambuja.noxus.resources.SummonerDTO;
import com.antonioazambuja.noxus.resources.SummonerDataChampionV1;
import com.antonioazambuja.noxus.resources.SummonerDataLaneV1;

@Service
public class SummonerDataV1Service {

	@Autowired
	private SummonerV4Service summonerV4;

	@Autowired
	private MatchV4Service matchService;

	public List<MatchReferenceDto> getMatchReferencesDtoBySummoner(String summonerName, Boolean updateCache) {
		SummonerDTO summonerDto = summonerV4.getSummonerByName(summonerName, updateCache);
		List<MatchReferenceDto> matches = new ArrayList<MatchReferenceDto>();
		MatchlistDto matchlistDto = new MatchlistDto();
		Integer index = new Integer(0);
		do {
			index = index + 100;
			matchlistDto = matchService.getMatchesByAccountId(summonerDto.getAccountId(), index, index-100, updateCache);
			matches.addAll(matchlistDto.getMatches());
		} while (matchlistDto.getEndIndex() == index);
		return matches;
	}

	public List<MatchDto> getMatchesBySummoner(List<MatchReferenceDto> matchesReferenceDto, Boolean updateCache) {
		return matchesReferenceDto
				.parallelStream()
				.map(match -> matchService.getMatchById(match.getGameId(), updateCache))
				.filter(match -> !match.getGameMode().equals("TUTORIAL_MODULE_1"))
				.collect(Collectors.toList());
	}

	public List<MatchDto> getLaneMatchesBySummoner(List<MatchReferenceDto> matchesReferenceDto, String lane, Boolean updateCache) {
		return matchesReferenceDto
				.parallelStream()
				.filter(matchReferenceDto -> matchReferenceDto.getLane().equals(lane.toUpperCase()))
				.map(matchReferenceDto -> matchService.getMatchById(matchReferenceDto.getGameId(), updateCache))
				.filter(matchDto -> !matchDto.getGameMode().equals("TUTORIAL_MODULE_1"))
				.collect(Collectors.toList());
	}

	public List<MatchDto> getChampionMatchesBySummoner(List<MatchReferenceDto> matchesReferenceDto, Integer champion, Boolean updateCache) {
		return matchesReferenceDto
				.parallelStream()
				.filter(matchReferenceDto -> matchReferenceDto.getChampion().equals(champion))
				.map(matchReferenceDto -> matchService.getMatchById(matchReferenceDto.getGameId(), updateCache))
				.filter(match -> !match.getGameMode().equals("TUTORIAL_MODULE_1"))
				.collect(Collectors.toList());
	}

	public Integer winMatches(List<MatchDto> matches, SummonerDTO summonerDTO) {
		return matches.parallelStream()
				.filter(match -> match.getParticipants()
						.stream()
						.filter(participant -> participant.getParticipantId().equals(match.getParticipantIdentities()
								.stream()
								.filter(participantIdentities -> participantIdentities.getPlayer().getAccountId().equals(summonerDTO.getAccountId()))
								.findFirst().orElse(null).getParticipantId()))
						.findFirst().orElse(null).getStats().getWin())
				.collect(Collectors.toList()).size();
	}

	public SummonerDataLaneV1 getLaneMatchesDataAnalysisV1(String lane, String summonerName, Boolean updateCache) {
		List<MatchReferenceDto> matchesReferenteDto = getMatchReferencesDtoBySummoner(summonerName, updateCache);
		List<MatchDto> matches = getLaneMatchesBySummoner(matchesReferenteDto, lane, updateCache);
		SummonerDTO summonerDTO = summonerV4.getSummonerByName(summonerName, updateCache);
		Integer winMatchesTotal = winMatches(matches, summonerDTO);
		Double winRate = Math.floor((winMatchesTotal / new Double(matches.size())) * 100);
		return new SummonerDataLaneV1(lane, winRate, matches, summonerDTO);
	}

	public SummonerDataChampionV1 getChampionMatchesDataAnalysisV1(Integer championId, String summonerName, Boolean updateCache) {
		List<MatchReferenceDto> matchesReferenteDto = getMatchReferencesDtoBySummoner(summonerName, updateCache);
		List<MatchDto> matches = getChampionMatchesBySummoner(matchesReferenteDto, championId, updateCache);
		SummonerDTO summonerDTO = summonerV4.getSummonerByName(summonerName, updateCache);
		Integer winMatchesTotal = winMatches(matches, summonerDTO);
		Double winRate = Math.floor((winMatchesTotal / new Double(matches.size())) * 100);
		return new SummonerDataChampionV1(championId, winRate, matches, summonerDTO);
	}

}
