package com.soccer.action;

import javax.annotation.Resource;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.InterceptorRef;
import org.apache.struts2.convention.annotation.InterceptorRefs;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.validator.annotations.FieldExpressionValidator;
import com.opensymphony.xwork2.validator.annotations.RequiredStringValidator;
import com.opensymphony.xwork2.validator.annotations.StringLengthFieldValidator;
import com.soccer.domain.League;
import com.soccer.exception.SoccerException;
import com.soccer.service.LeagueService;

@Controller
@Namespace("/admin")
@ParentPackage("struts-default")
@Action("addLeagueAction")
@Results({
	@Result(name="success" , location="/admin/AddLeagueSucc.jsp"),
	@Result(name="input" , location="/admin/AddLeague.jsp")
})
public class AddLeagueAction extends ActionSupport {
	
	@Resource
	private LeagueService leagueService;
	
	private int lid;
	private String lyear;
	private String season;
	private String title;
	
	public String getLyear() {
		return lyear;
	}
	public void setLyear(String year) {
		this.lyear = year;
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
	@RequiredStringValidator(
		key = "error.title.required",
		trim = true,
		shortCircuit = true
	)
	@StringLengthFieldValidator(
		key = "error.title.length",
		minLength = "4",
		maxLength = "20"
	)
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	
	
	//业务逻辑
	@Override
	public String execute(){
		League league;
		try {
			league = new League(Integer.parseInt(lyear), season, title);
			leagueService.saveLeague(league);
		} catch (SoccerException e) {
			e.printStackTrace();
			return INPUT;
		}
		return SUCCESS;
	}
	
	//校验
	@Override
	public void validate() {
		int y = 0;
		if(lyear == null || lyear.trim().length() == 0) {
			addFieldError("lyear", getText("error.lyear.required"));
		}
		else {
			try {
				y = Integer.parseInt(lyear);
				if(y < 2008 || y > 2025) {
					addFieldError("lyear", getText("error.lyear.range" , new String[]{"2008" , "2025"}));
				}
			} catch (Exception e) {
				addFieldError("lyear", getText("error.lyear.posivive"));
			}
		}
		
	}	
	
}
