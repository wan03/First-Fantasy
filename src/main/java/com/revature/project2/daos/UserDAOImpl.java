package com.revature.project2.daos;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.revature.project2.exceptions.UserInsertionException;
import com.revature.project2.pojo.User;

@Component
public class UserDAOImpl implements UserDAO {
	
	private SessionFactory sf;
	
	@Autowired
	public void setSf(SessionFactory sf) {
		this.sf = sf;
	}
	
	@Override
	public User getUserByEmail(String email) {
		Session sess = sf.openSession();
		return sess.get(User.class, email);
	}

	@Override
	public void addNewUser(User user) throws UserInsertionException {
		Session sess = sf.openSession();
		Transaction tx = sess.beginTransaction();
		sess.save(user);
		tx.commit();
	}

	@Override
	public void updateUser(User user) throws UserInsertionException {
		Session sess = sf.openSession();
		Transaction tx = sess.beginTransaction();
		sess.saveOrUpdate(user);
		tx.commit();
	}

}
