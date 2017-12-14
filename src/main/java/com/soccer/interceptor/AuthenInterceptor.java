package com.soccer.interceptor;

import java.util.Map;

import org.apache.struts2.convention.annotation.InterceptorRef;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;
import com.soccer.action.AuthenticationAction;
import com.soccer.domain.Admin;

/*@InterceptorRef(value = "AuthenInterceptor")*/
public class AuthenInterceptor extends AbstractInterceptor {
	
	public static final String USER = "adminuser";
	public static final String NEXTURL = "nexturl";
	
	@Override
	public String intercept(ActionInvocation invoc) throws Exception {
		ActionContext request = invoc.getInvocationContext();
		Map session = request.getSession();
		
		//获取拦截的AuthenticationAction对象
		AuthenticationAction authenAction = (AuthenticationAction)invoc.getAction();
		String page = authenAction.getPage();
		
		//从session中获取admin对象
		Admin admin = (Admin)session.get(USER);
		System.out.println(admin);
		System.out.println(page);
		//如果未取到admin对象
		if(admin == null) {
			//将页面地址保存到session中
			session.put(NEXTURL, page);
			//转发到登录页
			return "login";
		}
		//放过请求
		invoc.invoke();
		return null;
	}

}
