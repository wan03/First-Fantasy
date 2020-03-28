package com.revature.project2.daos;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.revature.project2.pojo.Actor;

@Component
public class ActorDAOImpl implements ActorDAO {

	private SessionFactory sf;

	@Autowired
	public void setSf(SessionFactory sf) {
		this.sf = sf;
	}
	
	@Override
	public Actor getActorById(int id) {
		Session sess = sf.openSession();
		return sess.get(Actor.class, id);
	}

}
