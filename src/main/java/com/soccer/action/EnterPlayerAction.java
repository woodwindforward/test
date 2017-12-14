package com.soccer.action;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.validator.annotations.EmailValidator;
import com.opensymphony.xwork2.validator.annotations.RequiredStringValidator;
import com.soccer.domain.Player;

@Controller
@Namespace("/register")
@ParentPackage("struts-default")
@Action("enterPlayerAction")
@Results({
	@Result(name="input" , location="/register/EnterPlayer.jsp"),
	@Result(name="success" , location="/register/SelectDivision.jsp")
})
public class EnterPlayerAction extends ActionSupport {
	private String name;
	private String address;
	private String city;
	private String email;
	
	private Player player;
	
	@RequiredStringValidator(
		key = "error.name.required",
		trim = true
	)
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@RequiredStringValidator(
		key = "error.address.required",
		trim = true
	)
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	@RequiredStringValidator(
		key = "error.city.required",
		trim = true
	)
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	@RequiredStringValidator(
		key = "error.email.required",
		trim = true,
		shortCircuit = true
	)
	@EmailValidator(
		key = "error.email.pattern"		
	)
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	public Player getPlayer() {
		return player;
	}
	public void setPlayer(Player player) {
		this.player = player;
	}
	
	public String execute() {
		player = new Player(name, address, city, email);
		ActionContext.getContext().getSession().put("player", player );
		return "success";
	}
}
