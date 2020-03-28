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
    //document.getElementById("submitBtn").setAttribute("disabled", "true");
    this.dungeonService.getDto().subscribe(playerList => this.playerList = playerList);
    //this.dungeonService.getPlayer().subscribe(player => this.player = player)
  }

  player = PLAYER;
  //playerList =[];
  playerList: Player[] = [PLAYER];
  allReady = [false,false,false,false];


   submitFunc(){
     console.log("submitFunc()");
     this.dungeonService.postPlayerList(this.playerList);
     this.dungeonService.getDto();
   }


  warriorAction(player){
    console.log(this.playerList);
  }

  mageAction(player){
  }

  guardAction(player){
  }

  healerAction(player){
  }

}
