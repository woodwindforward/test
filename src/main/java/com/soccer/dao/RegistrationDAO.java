package com.soccer.dao;

import javax.annotation.Resource;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.springframework.orm.hibernate4.HibernateCallback;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.soccer.domain.Registration;

@Repository
@Transactional
public class RegistrationDAO {
	
	@Resource
	private HibernateTemplate hibernateTemplate;
	
	//添加分组信息
	public void addRegistration(Registration reg) {
		hibernateTemplate.execute(new HibernateCallback(){

			@Override
			public Object doInHibernate(Session session) throws HibernateException {
				session.save(reg);
				return null;
			}
			
		});
	}

}
