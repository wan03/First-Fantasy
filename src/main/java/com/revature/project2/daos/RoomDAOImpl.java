package com.revature.project2.daos;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.revature.project2.pojo.Room;

public class RoomDAOImpl implements RoomDAO {
	
	private SessionFactory sf;
	
	@Autowired
	public void setSf(SessionFactory sf) {
		this.sf = sf;
	}
	
	@Override
	public Room getRoomByName(String name) {
		Session sess = sf.openSession();
		return sess.get(Room.class, name);
	}

}
