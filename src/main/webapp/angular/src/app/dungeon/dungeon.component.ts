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
    this.dungeonService.getPlayerList().subscribe(playerList => this.playerList = playerList);
    //this.dungeonService.getPlayer().subscribe(player => this.player = player)
  }

  player = PLAYER;
  playerList =[];
  allReady = [false,false,false,false];


   submitFunc(){
     console.log("submitFunc()");
     this.dungeonService.postPlayerList(this.playerList);
   }


  warriorAction(player){
    // this.player.targets = [1];
    // this.dungeonService.attack(this.player);
    // this.dungeonService.attack(this.player);
    this.playerList.push(player);
    console.log(this.playerList);
    // this.allReady[0] = true;
    // document.getElementById("warriorActionBtn").setAttribute("disabled", "true");
    // if(this.allReady.every((currentValue) => true))
    //   document.getElementById("submitBtn").setAttribute("disabled", "false");
  }

  mageAction(player){
    // this.player.targets = [1];
    // this.dungeonService.attack(this.player);
    //this.playerList.push(player);
    // this.allReady[1] = true;
    // document.getElementById("mageActionBtn").setAttribute("disabled", "true");
    // if(this.allReady.every((currentValue) => true))
    //   document.getElementById("submitBtn").setAttribute("disabled", "false");
  }

  guardAction(player){
    // this.player.targets = [1];
    // this.dungeonService.attack(this.player);
    //this.playerList.push(player);
    // this.allReady[2] = true;
    // document.getElementById("guardActionBtn").setAttribute("disabled", "true");
    // if(this.allReady.every((currentValue) => true))
    //   document.getElementById("submitBtn").setAttribute("disabled", "false");
  }

  healerAction(player){
    // this.player.targets = [1];
    // this.dungeonService.attack(this.player);
    //this.playerList.push(player);
    // this.allReady[3] = true;
    // document.getElementById("healerActionBtn").setAttribute("disabled", "true");
    // if(this.allReady.every((currentValue) => true))
    //   document.getElementById("submitBtn").setAttribute("disabled", "false");
  }

}
