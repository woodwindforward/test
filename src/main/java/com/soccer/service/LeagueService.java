package com.soccer.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.soccer.dao.LeagueDAO;
import com.soccer.domain.League;
import com.soccer.exception.SoccerException;

@Service
public class LeagueService {
	
	@Resource
	private LeagueDAO leagueDAO;
	
	//添加新联赛
	@Transactional(propagation=Propagation.REQUIRED, rollbackFor=SoccerException.class)
	public void saveLeague(League league) throws SoccerException {
		leagueDAO.addLeague(league);
	}
	
	//查询所有联赛
	@Transactional(propagation=Propagation.SUPPORTS, readOnly=true)
	public List<League> getLeagues() {
		return leagueDAO.getLeagues();
	}
	
	//查询联赛对象
	@Transactional(propagation=Propagation.SUPPORTS, readOnly=true)
	public League getLeague(int lyear, String season) {
		return leagueDAO.getLeague(lyear, season);
	}

}
