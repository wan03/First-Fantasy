package com.revature.project2.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.project2.daos.PlayerDAO;
import com.revature.project2.daos.PlayerDAOImpl;
import com.revature.project2.pojo.Player;

@Service
public class DungeonService {
	Player actor = new Player();
	PlayerDAO playerDao = new PlayerDAOImpl();
	
	@Autowired
	public Player getPlayer(int id) {
		return playerDao.getPlayerById(id);
	}


	public void changePlayer(Player player) {
		playerDao.updatePlayer(player);
	}
}
