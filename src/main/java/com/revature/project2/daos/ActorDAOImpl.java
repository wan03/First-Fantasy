package com.revature.project2.daos;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.revature.project2.pojo.Actor;
import com.revature.project2.util.SessionFactoryUtil;

@Component
public class ActorDAOImpl implements ActorDAO {

	private SessionFactory sf = SessionFactoryUtil.getSessionFactoryUtil().getSessionFactory();

	//@Autowired
	public void setSf(SessionFactory sf) {
		this.sf = sf;
	}
	
	@Override
	public Actor getActorById(int id) {
		Session sess = sf.openSession();
		return sess.get(Actor.class, id);
	}

}
