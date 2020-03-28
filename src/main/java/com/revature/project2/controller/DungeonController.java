package com.revature.project2.controller;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.revature.project2.pojo.Actor;
import com.revature.project2.pojo.BattleDTO;
import com.revature.project2.service.DungeonService;

@CrossOrigin(origins = "http://localhost:4200")
@Controller
public class DungeonController {
	private static final Logger log = Logger.getRootLogger();
	DungeonService ds = new DungeonService();


    @PostMapping(path = "/dungeon")
    @ResponseBody
	public BattleDTO dungeonInput(@RequestBody ArrayList<Actor> playerList){
    	log.trace("dungeonInput(ArrayList<Actor>)");
    	log.debug("playerList == null : " + (playerList==null));
//    	for(Actor player : playerList)
//    		System.out.println(player.toString());
    	BattleDTO battleDto = ds.playRound(playerList);
    	return battleDto;
   	}


    @GetMapping(path = "/dungeon")
    @ResponseBody
    public List<Actor> dungeonOutput(){
    	log.trace("dungeonOutput(int)");
    	List<Actor> actorList = ds.getActors();

    	return actorList;
   	}
}
