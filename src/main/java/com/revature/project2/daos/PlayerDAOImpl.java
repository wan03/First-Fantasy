package com.revature.project2.daos;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.revature.project2.pojo.Player;

public class PlayerDAOImpl implements PlayerDAO {

	private SessionFactory sf;

	@Autowired
	public void setSf(SessionFactory sf) {
		this.sf = sf;
	}

	@Override
	public Player getPlayerById(int id) {
		Session sess = sf.openSession();
		return sess.get(Player.class, id);
	}

}
