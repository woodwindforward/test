package com.soccer.action;

import javax.annotation.Resource;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.validator.annotations.FieldExpressionValidator;
import com.soccer.domain.League;
import com.soccer.domain.Player;
import com.soccer.service.LeagueService;
import com.soccer.service.RegisterService;

@Controller
@Namespace("/register")
@ParentPackage("struts-default")
@Action("selectDivisionAction")
@Results({
	@Result(name="input" , location="/register/SelectDivision.jsp"),
	@Result(name="success" , location="/register/RegisterSucc.jsp")
})
public class SelectDivisionAction extends ActionSupport {
	
	@Resource
	private LeagueService leagueService;
	
	@Resource
	private RegisterService regService;
	
	private String lyear;
	private String season;
	private String division;
	
	private Player player;
	private League league;
	
	public String getLyear() {
		return lyear;
	}
	public void setLyear(String lyear) {
		this.lyear = lyear;
	}
	@FieldExpressionValidator(
		key = "error.season.required",
		expression = "season!='UNKNOWN'"
	)
	public String getSeason() {
		return season;
	}
	public void setSeason(String season) {
		this.season = season;
	}
	@FieldExpressionValidator(
		key = "error.division.required",
		expression = "division!='UNKNOWN'"
	)
	public String getDivision() {
		return division;
	}
	public void setDivision(String division) {
		this.division = division;
	}
	
	public Player getPlayer() {
		return player;
	}
	public void setPlayer(Player player) {
		this.player = player;
	}
	
	public League getLeague() {
		return league;
	}
	public void setLeague(League league) {
		this.league = league;
	}
	
	@Override
	public String execute() throws Exception {
		try {
			player = (Player)( ActionContext.getContext().getSession()).get("player");
			league = leagueService.getLeague(Integer.parseInt(lyear), season);
			System.out.println("222");
			System.out.println(league);
			regService.register(player, league.getLid(), division);
			System.out.println("333");
			return "success";
		} catch (Exception e) {
			addActionError(e.getMessage());
			return "input";
		}
	}
	@Override
	public void validate() {
		int y = 0;
		if(lyear == null || lyear.trim().length() == 0) {
			addFieldError("lyear", "请输入年份");
		}
		else {			
			try {
				y = Integer.parseInt(lyear);
				if(y < 2008 || y > 2030) {
					addFieldError("lyear" ,"年份的范围应该在2010-2030之间");
				}
			} catch (NumberFormatException e) {
				addFieldError("lyear" ,"年份请输入整数");
			}
		}
		
	}	
	
}
