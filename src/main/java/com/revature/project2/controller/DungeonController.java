package com.revature.project2.controller;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.project2.pojo.Player;
import com.revature.project2.service.DungeonService;

@CrossOrigin(origins = "http://localhost:4200")
@Controller
public class DungeonController {
	private static final Logger log = Logger.getRootLogger();
	DungeonService dungeonService = new DungeonService();

    //public void dungeonInput(@RequestBody Player playerList){
//    @PostMapping(path = "/dungeon")
//    @ResponseBody
//	public ResponseEntity<Player> dungeonInput(@RequestBody Player playerList){
//    	log.trace("dungeonInput(List<Player>)");
//    	log.debug("playerList == null : " + (playerList==null));
//    	log.debug("playerList.toString()" + playerList.toString());
//    	//log.debug(playerList.get(0).toString());
//    	//return dungeonService.updateBattle(playerList);
////    	for(Player player : playerList)
////    		System.out.println(player.toString());
//    	return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body(null);
//   	}

    @PostMapping("/dungeon")
	public void registerUser(Player player) {
    	Player player2 = new Player();
    	ObjectMapper mapper = new ObjectMapper();
    	String jsonString;
		try {
			jsonString = mapper.writeValueAsString(player2);
			System.out.println(jsonString);
		} catch (JsonProcessingException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			//userService.registerUser(player);
			//return ResponseEntity.created(new URI('/'+player.getName())).body(player);
//		} catch (UserInsertionException e) {
//			e.printStackTrace();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		//return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body(null);
		
	}

//    @GetMapping(path = "/dungeon")
//    @ResponseBody
//    public ArrayList<Player> dungeonOutput(@RequestParam(required = false) ArrayList<Player> playerList){
//    	log.trace("dungeonOutput(List<Player>)");
//    	//return dungeonService.updateBattle(playerList);
////    	for(Player player : playerList) {
////    		log.debug("Inside for loop");
////    		log.debug(player.toString());
////    	}
//    	return playerList;
//   	}

    @GetMapping("/dungeon/{victoryFlag}")
	public Integer getVictoryStatus(@RequestParam(required = false) Integer victoryFlag) {
		//if (player != null) {
			//return carService.getCarsByOwner(player);
		//}
		//return carService.getAllCars();
    	return dungeonService.checkVictoryStatus();
	}
}
