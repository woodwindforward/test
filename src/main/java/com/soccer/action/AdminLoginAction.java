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
import com.opensymphony.xwork2.validator.annotations.RequiredStringValidator;
import com.soccer.domain.Admin;
import com.soccer.interceptor.AuthenInterceptor;
import com.soccer.service.LoginService;

@Controller
@Namespace("/admin")
@ParentPackage("struts-default")
@Action("adminLoginAction")
@Results({ 
		@Result(name = "index", location = "/Index.jsp"), 
		@Result(name = "input", location = "/admin/Login.jsp"),
		@Result(name = "nextUrl",type="redirect",  location = "/${forward}")
})
public class AdminLoginAction extends ActionSupport {
	
	@Resource
	private LoginService loginService;
	
	private String username;
	private String password;
	private String forward;
	
	private Admin admin;

	@RequiredStringValidator(
			key = "error.username.required", 
			trim = true
	)
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	@RequiredStringValidator(
			key = "error.password.required", 
			trim = true
	)
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getForward() {
		return forward;
	}

	public void setForward(String forward) {
		this.forward = forward;
	}
	
	public Admin getAdmin() {
		return admin;
	}

	public String execute() {
		try {
			admin = loginService.getAdmin(username, password);
			System.out.println(admin);
			if(admin == null){
				return INPUT;
			}
			ActionContext.getContext().getSession().put(AuthenInterceptor.USER, admin);
			forward = (String) ActionContext.getContext().getSession().get(AuthenInterceptor.NEXTURL);
			System.out.println(forward);
			// 如果session已超时
			if (forward == null) {
				// 转到首页面
				return "index";
			} else {
				return "nextUrl";
			}
		} catch (Exception e) {
			e.printStackTrace();
			return INPUT;
		}
	}
}
