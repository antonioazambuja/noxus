package com.antonioazambuja.noxus.service;

import java.util.Calendar;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SummonerAnalyze {

	@Autowired
	private SummonerV4Service summonerV4;

	@Autowired
	private MatchV4Service matchService;

	public void getHigherWinrateChampions(String summonerName) {
		Calendar beginTime = Calendar.getInstance();
		beginTime.set(Calendar.YEAR, 1, 1);
		Calendar endTime = Calendar.getInstance();
		endTime.setTime(new Date());
		System.out.println(matchService.getMatchesByAccountId(summonerV4.getSummonerByName(summonerName).getAccountId(), endTime.getTimeInMillis(), beginTime.getTimeInMillis(), 100, 0));
	}
}
