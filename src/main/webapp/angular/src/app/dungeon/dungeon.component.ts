import { Component, OnInit } from '@angular/core';
import { DungeonService } from './dungeon.service';
import { Player } from '../Player';

@Component({
  selector: 'app-dungeon',
  templateUrl: './dungeon.component.html',
  styleUrls: ['./dungeon.component.css']
})
export class DungeonComponent implements OnInit {

  constructor(private dungeonService: DungeonService) { }

  ngOnInit(): void {
    //document.getElementById("submitBtn").setAttribute("disabled", "true");
    this.dungeonService.getPlayer().subscribe(player => this.player = player)
  }

  player: Player;

  // submitFunc(action){
  //   this.dungeonService.submitFunc();
  // }


  warriorAction(){
    this.player.targets = [1];
    this.dungeonService.attack(this.player);
  }

  mageAction(){
    this.player.targets = [1];
    this.dungeonService.attack(this.player);
  }

  guardAction(){
    this.player.targets = [1];
    this.dungeonService.attack(this.player);
  }

  healerAction(){
    this.player.targets = [1];
    this.dungeonService.attack(this.player);
  }

}
