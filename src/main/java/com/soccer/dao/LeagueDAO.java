package com.soccer.dao;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate4.HibernateCallback;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.soccer.domain.League;

@Repository
@Transactional
public class LeagueDAO {
	@Resource
	private HibernateTemplate hibernateTemplate;
	
	//添加新联赛
	public void addLeague(final League lea){
		hibernateTemplate.execute(new HibernateCallback(){

			@Override
			public Object doInHibernate(Session session) throws HibernateException {
				session.save(lea);
				return null;
			}
			
		});
	}
	
	//查询所有联赛
	public List<League> getLeagues() {
		return (List<League>)hibernateTemplate.execute(new HibernateCallback(){

			@Override
			public Object doInHibernate(Session session) throws HibernateException {
				String hql = "from League";
				Query query = session.createQuery(hql);
				List list = query.list();
				return list;
			}
			
		});
	}

	//按年份和季节查询联赛
	public League getLeague(int lyear, String season){
		return (League)hibernateTemplate.execute(new HibernateCallback(){

			@Override
			public Object doInHibernate(Session session) throws HibernateException {
				String hql = "from League where lyear = ? and season = ?";
				Query query = session.createQuery(hql);
				query.setInteger(0, lyear);
				query.setString(1, season);
				return query.list().get(0);
			}
			
		});
	}

}
