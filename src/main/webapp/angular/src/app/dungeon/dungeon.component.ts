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
    //this.dungeonService.getPlayer().subscribe(PLAYER => this.PLAYER = PLAYER)
  }



  // submitFunc(action){
  //   this.dungeonService.submitFunc();
  // }


  warriorAction(){
    // this.player.targets = [1];
    // this.dungeonService.attack(this.player);
     this.dungeonService.attack(PLAYER);
  }

  mageAction(){
    // this.player.targets = [1];
    // this.dungeonService.attack(this.player);
  }

  guardAction(){
    // this.player.targets = [1];
    // this.dungeonService.attack(this.player);
  }

  healerAction(){
    // this.player.targets = [1];
    // this.dungeonService.attack(this.player);
  }

}
