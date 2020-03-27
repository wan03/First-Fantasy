package com.revature.project2.service;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.project2.daos.PlayerDAO;
import com.revature.project2.daos.PlayerDAOImpl;
import com.revature.project2.pojo.Player;

//@Service
public class DungeonService {
	private static final Logger log = Logger.getRootLogger();
	Player actor = new Player();
	PlayerDAO playerDao = new PlayerDAOImpl();
	
	//@Autowired
	public Player getPlayer(int id) {
		log.trace("getPlayer(int)");
		return playerDao.getPlayerById(id);
	}

	public void changePlayer(Player player) {
		log.trace("changePlayer(Player)");
		playerDao.updatePlayer(player);
	}
}
