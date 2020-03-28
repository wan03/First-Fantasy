package com.revature.project2.service;

import java.util.List;

import org.apache.log4j.Logger;

import com.revature.project2.daos.PlayerDAO;
import com.revature.project2.daos.PlayerDAOImpl;
import com.revature.project2.pojo.Actor;
import com.revature.project2.pojo.BattleDTO;
import com.revature.project2.pojo.Player;

//@Service
public class DungeonService {
	private static final Logger log = Logger.getRootLogger();
	
	BattleService bs;
	FieldService fs;

	public DungeonService() {
		bs = BattleService.getBattleService();
		fs = FieldService.getField();
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

	public BattleDTO playRound(List<Actor> update) {
		log.trace("playRound(List<Actor>");
	        fs.setCombatants(update);
	        bs.round();
	        return new BattleDTO (fs.getCombatants(),bs.getStatus(),bs.toString());
	}
}
