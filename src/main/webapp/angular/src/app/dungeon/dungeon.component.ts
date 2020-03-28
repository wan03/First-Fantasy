import { Component, OnInit } from '@angular/core';
import { DungeonService } from './dungeon.service';
import { Player } from '../player-declaration';
import { PLAYER } from '../mock-player';

@Component({
  selector: 'app-dungeon',
  templateUrl: './dungeon.component.html',
  styleUrls: ['./dungeon.component.css']
})
export class DungeonComponent implements OnInit {

  constructor(private dungeonService: DungeonService) { }

  ngOnInit(): void {
    document.getElementById("submitBtn").setAttribute("disabled", "true");
    this.dungeonService.getDto().subscribe(playerList => this.playerList = playerList);

    this.warrior.name = "not warrior";
  }

  playerList: Player[] = [PLAYER];
  currentHero: string = "";
  //allReady = [false,false,false,false];


  // Get hero info
  warrior: Player = PLAYER;
  mage: Player = PLAYER;
  gaurd: Player = PLAYER;
  healer: Player = PLAYER;

  


  submitFunc(){
    console.log("submitFunc()");
    this.dungeonService.postPlayerList(this.playerList);
    this.dungeonService.getDto();
  }


  warriorAction(){
    console.log("Warrior Name: " + this.warrior.name);
    console.log("Warrior actor" + JSON.stringify(this.warrior));
    document.getElementById("warriorActionBtn").setAttribute('style', 'background-color: black');
    this.currentHero = 'warrior';
    console.log("warriorAction()");
    console.log(this.playerList);
    
  }

  mageAction(){
    console.log("mageAction()");
  }

  guardAction(){
    console.log("guardAction()");
  }

  healerAction(){
    console.log("healerAction()");
  }



  goblinFn1(){

  }

  goblinFn2(){

  }
  
  goblinFn3(){

  }

  goblinFn4(){

  }

  checkAllReady(allReady){
    // Make the submit button selectable once all heroes took their turns
    if(allReady[0] == true &&
      allReady[1] == true &&
      allReady[2] == true &&
      allReady[3] == true) {
      document.getElementById("submitBtn").setAttribute("disabled", "false");
    }
  }
}
