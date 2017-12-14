package com.soccer.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.soccer.dao.PlayerDAO;
import com.soccer.dao.RegistrationDAO;
import com.soccer.domain.League;
import com.soccer.domain.Player;
import com.soccer.domain.Registration;
import com.soccer.exception.SoccerException;

@Service
public class RegisterService {
	
	@Resource
	private PlayerDAO playerDAO;
	@Resource
	private RegistrationDAO regDAO;
	
	//注册联赛
	@Transactional(propagation=Propagation.REQUIRED, rollbackFor=SoccerException.class)
	public void register(Player player , int lid, String division) {
		int pid = playerDAO.addPlayer(player);
		Registration reg = new Registration(lid, pid, division);
		regDAO.addRegistration(reg);
	}
	
	//查询所有球员信息
	@Transactional(propagation=Propagation.SUPPORTS, readOnly=true)
	public List<Player> getPlayers() {
		return playerDAO.getPlayers();
	}

}
