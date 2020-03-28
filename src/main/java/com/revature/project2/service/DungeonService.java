package com.revature.project2.service;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.revature.project2.daos.ActorDAOImpl;
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
	ActorDAOImpl ad = new ActorDAOImpl();
	public List<Actor> getActors(){
		List<Actor> actorList = new ArrayList<Actor>();
		actorList.add(ad.getActorById(1));
		actorList.add(ad.getActorById(2));
		return actorList;
	}

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
		log.trace("playRound(List<Actor>)");
	        fs.setCombatants(update);
	        List<Actor> actorList = fs.getCombatants();
	        for(Actor actor : actorList)
	        	System.out.println(actor);
	        String battleLog = bs.round();
	        log.debug(battleLog);
	        return new BattleDTO (fs.getCombatants(),bs.getStatus(),battleLog);
	}
}
