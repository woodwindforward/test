package com.soccer.dao;

import javax.annotation.Resource;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate4.HibernateCallback;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.soccer.domain.Admin;

@Repository
@Transactional
public class AdminDAO{
	
	@Resource
	private HibernateTemplate hibernateTemplate;

	public Admin getAdmin(String username, String password) {
		return (Admin)hibernateTemplate.execute(new HibernateCallback(){

			@Override
			public Object doInHibernate(Session session) throws HibernateException {
				String hql = "from Admin where username = ? and password = ?";
				Query query = session.createQuery(hql);
				query.setString(0, username);
				query.setString(1, password);
//				return query.list().get(0);
				return query.uniqueResult();
			}
			
		});
	}

}
