package com.revature.project2.daos;

import org.hibernate.SessionFactory;

import com.revature.project2.pojo.Player;

public interface PlayerDAO {
	public void setSf(SessionFactory sf);
	public Player getPlayerById(int id);
	public void updatePlayer(Player player);
}
