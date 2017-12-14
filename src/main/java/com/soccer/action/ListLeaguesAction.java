package com.soccer.action;

import java.util.List;

import javax.annotation.Resource;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import org.springframework.stereotype.Controller;

import com.soccer.domain.League;
import com.soccer.domain.Player;
import com.soccer.service.LeagueService;
import com.soccer.service.RegisterService;

@Controller
@Namespace("/")
@ParentPackage("struts-default")
@Results({
	@Result(name="getLeagues", location="/ListLeagues.jsp"),
	@Result(name="input", type="redirect", location="/Index.jsp")
})
public class ListLeaguesAction {

	@Resource
	private LeagueService leagueService;
	
	private List<League> leagues;
	
	public List<League> getLeagues() {
		return leagues;
	}
	public void setLeagues(List<League> leagues) {
		this.leagues = leagues;
	}
	
	@Action("getLeaguesAction")
	public String leagues(){
		try {
			leagues = leagueService.getLeagues();
		} catch (Exception e) {
			e.printStackTrace();
			return "input";
		}
		return "getLeagues";
	}
	
}
