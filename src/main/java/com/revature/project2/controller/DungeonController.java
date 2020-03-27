package com.revature.project2.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.revature.project2.pojo.Player;
import com.revature.project2.service.DungeonService;

@Controller
public class DungeonController {
	DungeonService dungeonService = new DungeonService();

    @PostMapping(path = "/dungeon")
    @ResponseBody
    public List<Player> dungeonInput(List<Player> playerList){
    	//return dungeonService.updateBattle(playerList);
    	for(Player player : playerList)
    		System.out.println(player.toString());
    	return playerList;
   	}
    
    

}
