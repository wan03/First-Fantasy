package com.revature.project2.controller;

import java.util.ArrayList;

import org.apache.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.revature.project2.pojo.Actor;
import com.revature.project2.pojo.Player;
import com.revature.project2.service.DungeonService;

@CrossOrigin(origins = "http://localhost:4200")
@Controller
public class DungeonController {
	private static final Logger log = Logger.getRootLogger();
	DungeonService dungeonService = new DungeonService();

    @PostMapping(path = "/dungeon")
    @ResponseBody
	public ResponseEntity<Player> dungeonInput(@RequestBody ArrayList<Actor> playerList){
    	log.trace("dungeonInput(ArrayList<Actor>)");
    	log.debug("playerList == null : " + (playerList==null));
//    	for(Actor player : playerList)
//    		System.out.println(player.toString());
    	return ResponseEntity.status(HttpStatus.OK).body(null);
   	}


    @GetMapping(path = "/dungeon")
    @ResponseBody
    //public ArrayList<Player> dungeonOutput(@RequestParam(required = false) ArrayList<Player> playerList){
    public void dungeonOutput(@RequestParam(required = false) ArrayList<Player> playerList){
    	log.trace("dungeonOutput(List<Player>)");
//    	return dungeonService.updateBattle(playerList);
//    	for(Player player : playerList) {
//    		log.debug("Inside for loop");
//    		log.debug(player.toString());
//    	}
    	//return playerList;
   	}

//    @GetMapping("/dungeon/{victoryFlag}")
//	public Integer getVictoryStatus(@RequestParam(required = false) Integer victoryFlag) {
//		if (player != null) {
//			return carService.getCarsByOwner(player);
//		}
//		return carService.getAllCars();
//    	return dungeonService.checkVictoryStatus();
//	}
}
