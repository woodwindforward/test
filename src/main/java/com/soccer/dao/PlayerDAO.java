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

import com.soccer.domain.Player;

@Repository
@Transactional
public class PlayerDAO {
	
	@Resource
	private HibernateTemplate hibernateTemplate;
	
	//添加球员
	public int addPlayer(Player player) {
		return (int)hibernateTemplate.execute(new HibernateCallback(){

			@Override
			public Object doInHibernate(Session session) throws HibernateException {
				session.save(player);
				return player.getPid();
			}
			
		});
	}
	
	//查询所有球员
	public List<Player> getPlayers() {
		return (List<Player>)hibernateTemplate.execute(new HibernateCallback(){

			@Override
			public Object doInHibernate(Session session) throws HibernateException {
				String hql = "from Player";
				Query query = session.createQuery(hql);
				List<Player> lists = query.list();
				return lists;
			}
			
		});
	}
	
}
