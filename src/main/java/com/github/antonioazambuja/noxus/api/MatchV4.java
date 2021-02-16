package com.github.antonioazambuja.noxus.api;

import java.util.HashSet;

import com.github.antonioazambuja.noxus.resources.MatchDto;
import com.github.antonioazambuja.noxus.resources.MatchTimelineDto;
import com.github.antonioazambuja.noxus.resources.MatchlistDto;

public interface MatchV4 {
	MatchDto getMatchById(Long matchId);
	MatchTimelineDto getTimelineMatchById(String matchId);
	MatchlistDto getMatchesByAccountId(String encryptedAccountId, Long endTime, Long beginTime, Integer endIndex, Integer beginIndex);
	MatchlistDto getMatchesByAccountId(String encryptedAccountId, HashSet<Integer> champion, Long endTime, Long beginTime, Integer endIndex, Integer beginIndex);
	MatchlistDto getMatchesByAccountId(String encryptedAccountId, HashSet<Integer> champion, HashSet<Integer> queue, Long endTime, Long beginTime, Integer endIndex, Integer beginIndex);
	MatchlistDto getMatchesByAccountId(String encryptedAccountId, HashSet<Integer> champion, HashSet<Integer> queue, HashSet<Integer> season, Long endTime, Long beginTime, Integer endIndex, Integer beginIndex);
	MatchlistDto getMatchesByAccountId(String encryptedAccountId, Integer endIndex, Integer beginIndex);
	MatchlistDto getMatchesByAccountId(String encryptedAccountId, HashSet<Integer> champion, Integer endIndex, Integer beginIndex);
}
