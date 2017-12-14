package com.soccer.action;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionSupport;

@Controller
/*@Namespace("/admin")
@ParentPackage("struts-default")
@Action("authenAction")
@Results({
	@Result(name="success" , location="/admin/addLeagueAction.jsp"),
	@Result(name="login" , location="/admin/Login.jsp"),
})*/
public class AuthenticationAction extends ActionSupport {
	private String page;

	public String getPage() {
		return page;
	}

	public void setPage(String page) {
		this.page = page;
	}
	
	public String execute() {
		System.out.println("拦截器");
		return "success";
	}
}
