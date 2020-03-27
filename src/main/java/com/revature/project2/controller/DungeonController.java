package com.revature.project2.controller;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.revature.project2.pojo.Player;

@Controller
public class DungeonController {
	private static final Logger log = Logger.getRootLogger();
	//DungeonService dungeonService = new DungeonService();

    @PostMapping(path = "/dungeon")
    @ResponseBody
    public void dungeonInput(List<Player> playerList){
    	log.trace("dungeonInput(List<Player>");
    	//return dungeonService.updateBattle(playerList);
    	for(Player player : playerList)
    		System.out.println(player.toString());
   	}

    @GetMapping(path = "/dungeon")
    @ResponseBody
    public List<Player> dungeonOutput(List<Player> playerList){
    	log.trace("dungeonOutput(List<Player>");
    	//return dungeonService.updateBattle(playerList);
    	for(Player player : playerList)
    		System.out.println(player.toString());
    	return playerList;
   	}
}
