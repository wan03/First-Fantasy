package com.revature.project2.daos;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.revature.project2.pojo.Player;

@Component
public class PlayerDAOImpl implements PlayerDAO {

	private SessionFactory sf;

	@Autowired
	public void setSf(SessionFactory sf) {
		this.sf = sf;
	}

	public Player getPlayerById(int id) {
		Session sess = sf.openSession();
		return sess.get(Player.class, id);
	}

	public void updatePlayer(Player player) {
		Session sess = sf.openSession();
		Transaction tx = sess.beginTransaction();
		sess.update(player);
		tx.commit();
	}

}
