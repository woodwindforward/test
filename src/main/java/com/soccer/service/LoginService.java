package com.soccer.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.soccer.dao.AdminDAO;
import com.soccer.domain.Admin;

@Service
public class LoginService {
	
	@Resource
	private AdminDAO adminDAO;

	//验证登录的用户名和密码是否正确
	@Transactional(propagation=Propagation.SUPPORTS, readOnly=true)
	public Admin getAdmin(String username, String password){
		return adminDAO.getAdmin(username, password);
	}
	
}
