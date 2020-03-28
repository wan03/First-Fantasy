package com.revature.project2.service;

import org.apache.log4j.Logger;

import com.revature.project2.daos.PlayerDAO;
import com.revature.project2.daos.PlayerDAOImpl;
import com.revature.project2.pojo.Player;

//@Service
public class DungeonService {
	private static final Logger log = Logger.getRootLogger();
	
	BattleService bs;

	public DungeonService() {
		bs = BattleService.getBattleService();
	}


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
	
	public Integer checkVictoryStatus() {
		return (Integer) bs.getStatus();
	}
}
