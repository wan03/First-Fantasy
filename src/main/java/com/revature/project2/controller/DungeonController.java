package com.revature.project2.controller;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.revature.project2.pojo.Actor;
import com.revature.project2.pojo.BattleDTO;
import com.revature.project2.service.DungeonService;

@CrossOrigin(origins = "http://localhost:4200")
@Controller
public class DungeonController {
	private static final Logger log = Logger.getRootLogger();
	DungeonService ds = new DungeonService();

    @PutMapping(path = "/dungeon")
    @ResponseBody
	public ResponseEntity<HttpStatus> dungeonInput(@RequestBody ArrayList<Actor> playerList){
    	log.trace("dungeonInput(ArrayList<Actor>)");
    	log.debug("playerList == null : " + (playerList==null));
//    	for(Actor player : playerList)
//    		System.out.println(player.toString());
    	ds.playRound(playerList);
    	return ResponseEntity.status(HttpStatus.OK).body(null);
   	}


    @GetMapping(path = "/dungeon")
    @ResponseBody
    public BattleDTO dungeonOutput(@RequestParam(required = false) Integer flag){
    	log.trace("dungeonOutput(int)");
    	if(flag == null)
    		log.debug("victoryFlag == null");
    	else
    		log.debug("victoryFlag != null");
    	BattleDTO battleDto = new BattleDTO();

    	battleDto.setStatus(0);
    	battleDto.setLog("Stuff happened");
    	List<Actor> actorList = new LinkedList<Actor>();
    	actorList.add(new Actor());
    	actorList.add(new Actor());
    	battleDto.setCharacters(actorList);

    	return battleDto;
   	}
}
