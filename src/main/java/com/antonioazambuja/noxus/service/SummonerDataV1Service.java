package com.antonioazambuja.noxus.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.antonioazambuja.noxus.resources.MatchDto;
import com.antonioazambuja.noxus.resources.MatchReferenceDto;
import com.antonioazambuja.noxus.resources.MatchlistDto;
import com.antonioazambuja.noxus.resources.SummonerDTO;
import com.antonioazambuja.noxus.resources.SummonerDataChampionV1;
import com.antonioazambuja.noxus.resources.SummonerDataLaneV1;
import com.antonioazambuja.noxus.resources.SummonerDataV1;

@Service
public class SummonerDataV1Service {

	@Autowired
	private SummonerV4Service summonerV4;

	@Autowired
	private MatchV4Service matchService;

	public List<MatchReferenceDto> getMatchReferencesDtoBySummoner(String summonerName) {
		SummonerDTO summonerDto = summonerV4.getSummonerByName(summonerName);
		List<MatchReferenceDto> matches = new ArrayList<MatchReferenceDto>();
		MatchlistDto matchlistDto = new MatchlistDto();
		Integer index = new Integer(0);
		do {
			index = index + 100;
			matchlistDto = matchService.getMatchesByAccountId(summonerDto.getAccountId(), index, index-100);
			matches.addAll(matchlistDto.getMatches());
		} while (matchlistDto.getEndIndex() == index);
		return matches;
	}

	public List<MatchDto> getWinMatchesBySummoner(String summonerName) {
		SummonerDTO summonerDTO = summonerV4.getSummonerByName(summonerName);
		return getMatchesBySummoner(summonerName)
				.stream()
				.filter(match -> match.getParticipants()
						.stream()
						.filter(participant -> participant.getParticipantId().equals(match.getParticipantIdentities()
								.stream()
								.filter(participantIdentities -> participantIdentities.getPlayer().getAccountId().equals(summonerDTO.getAccountId()))
								.findFirst().orElse(null).getParticipantId()))
						.findFirst().orElse(null).getStats().getWin())
				.collect(Collectors.toList());
	}

	public List<MatchDto> getMatchesBySummoner(String summonerName) {
		return getMatchReferencesDtoBySummoner(summonerName)
				.stream()
				.map(match -> matchService.getMatchById(match.getGameId()))
				.filter(match -> !match.getGameMode().equals("TUTORIAL_MODULE_1"))
				.collect(Collectors.toList());
	}

	public List<MatchDto> getLaneMatchesBySummoner(String summonerName, String lane) {
		return getMatchReferencesDtoBySummoner(summonerName)
				.stream()
				.filter(matchReferenceDto -> matchReferenceDto.getLane().equals(lane))
				.map(matchReferenceDto -> matchService.getMatchById(matchReferenceDto.getGameId()))
				.filter(matchDto -> !matchDto.getGameMode().equals("TUTORIAL_MODULE_1"))
				.collect(Collectors.toList());
	}

	public List<MatchDto> getChampionMatchesBySummoner(String summonerName, Integer champion) {
		return getMatchReferencesDtoBySummoner(summonerName)
				.stream()
				.filter(matchReferenceDto -> matchReferenceDto.getChampion().equals(champion))
				.map(matchReferenceDto -> matchService.getMatchById(matchReferenceDto.getGameId()))
				.filter(match -> !match.getGameMode().equals("TUTORIAL_MODULE_1"))
				.collect(Collectors.toList());
	}

	public SummonerDataLaneV1 getLaneMatchesDataAnalysisV1(String lane, String summonerName) {
		List<MatchDto> matches = getLaneMatchesBySummoner(summonerName, lane);
		SummonerDTO summonerDTO = summonerV4.getSummonerByName(summonerName);
		Integer winMatchesTotal = matches.stream()
				.filter(match -> match.getParticipants()
						.stream()
						.filter(participant -> participant.getParticipantId().equals(match.getParticipantIdentities()
								.stream()
								.filter(participantIdentities -> participantIdentities.getPlayer().getAccountId().equals(summonerDTO.getAccountId())).findFirst().orElse(null).getParticipantId())).findFirst().orElse(null).getStats().getWin())
				.collect(Collectors.toList()).size();
		Double winRate = Math.floor((winMatchesTotal / new Double(matches.size())) * 100);
		return new SummonerDataLaneV1(lane, winRate, matches, summonerDTO);
	}

	public SummonerDataChampionV1 getChampionMatchesDataAnalysisV1(Integer championId, String summonerName) {
		List<MatchDto> matches = getChampionMatchesBySummoner(summonerName, championId);
		SummonerDTO summonerDTO = summonerV4.getSummonerByName(summonerName);
		Integer winMatchesTotal = matches.stream()
				.filter(match -> match.getParticipants()
						.stream()
						.filter(participant -> participant.getParticipantId().equals(match.getParticipantIdentities()
								.stream()
								.filter(participantIdentities -> participantIdentities.getPlayer().getAccountId().equals(summonerDTO.getAccountId()))
								.findFirst().orElse(null).getParticipantId()))
						.findFirst().orElse(null).getStats().getWin())
				.collect(Collectors.toList()).size();
		Double winRate = Math.floor((winMatchesTotal / new Double(matches.size())) * 100);
		return new SummonerDataChampionV1(championId, winRate, matches, summonerDTO);
	}

	public SummonerDataV1 getMatchesDataAnalysisV1(String summonerName) {
		List<MatchDto> matches = getWinMatchesBySummoner(summonerName);
		SummonerDTO summonerDTO = summonerV4.getSummonerByName(summonerName);
		Integer winMatchesTotal = matches.stream()
				.filter(match -> match.getParticipants()
						.stream()
						.filter(participant -> participant.getParticipantId().equals(match.getParticipantIdentities()
								.stream()
								.filter(participantIdentities -> participantIdentities.getPlayer().getAccountId().equals(summonerDTO.getAccountId()))
								.findFirst().orElse(null).getParticipantId()))
						.findFirst().orElse(null).getStats().getWin())
				.collect(Collectors.toList()).size();
		Double winRate = Math.floor((winMatchesTotal / new Double(matches.size())) * 100);
		return new SummonerDataV1(winRate, matches, summonerDTO);
	}
}
