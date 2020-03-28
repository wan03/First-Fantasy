import { Component, OnInit } from '@angular/core';
import { DungeonService } from './dungeon.service';
import { Player } from '../player-declaration';
import { PLAYER,PLAYER1,PLAYER2,PLAYER3, } from '../mock-player';
import { findLast } from '@angular/compiler/src/directive_resolver';

@Component({
  selector: 'app-dungeon',
  templateUrl: './dungeon.component.html',
  styleUrls: ['./dungeon.component.css']
})
export class DungeonComponent implements OnInit {

  constructor(private dungeonService: DungeonService) { }

  ngOnInit(): void {
    document.getElementById("submitBtn").setAttribute("disabled", "");
    this.dungeonService.getDto().subscribe(playerList => this.playerList = playerList);

    this.warrior.name = "warrior";
    this.mage.name = "mage";
    this.guard.name = "guard";
    this.healer.name = "healer";
  }

  currentHero: string = "";
  allReady = [false,false,false,false];


  // Get hero info
  warrior: Player = PLAYER;
  mage: Player = PLAYER1;
  guard: Player = PLAYER2;
  healer: Player = PLAYER3;
  playerList: Player[] = [this.warrior, this.mage, this.guard, this.healer];

  


  submitFunc(){
    console.log("submitFunc()");
    this.dungeonService.postPlayerList(this.playerList);
    this.dungeonService.getDto();
  }


  warriorAction(){
    console.log("warriorAction()");
    console.log("warrior = " + this.warrior);
    document.getElementById("warriorActionBtn").setAttribute('style', 'background-color: grey');
    this.currentHero = this.warrior.name;
    console.log(this.playerList);
    document.getElementById("mageActionBtn").setAttribute("disabled","disabled");
    document.getElementById("guardActionBtn").setAttribute("disabled","disabled");
    document.getElementById("healerActionBtn").setAttribute("disabled","disabled");
  }

  mageAction(){
    console.log("mageAction()");
    document.getElementById("mageActionBtn").setAttribute('style', 'background-color: grey');
    this.currentHero = this.mage.name;
    console.log(this.playerList);
    document.getElementById("warriorActionBtn").setAttribute("disabled","disabled");
    document.getElementById("guardActionBtn").setAttribute("disabled","disabled");
    document.getElementById("healerActionBtn").setAttribute("disabled","disabled");
  }

  guardAction(){
    console.log("guardAction()");
    document.getElementById("guardActionBtn").setAttribute('style', 'background-color: grey');
    this.currentHero = this.guard.name;
    console.log(this.playerList);
    document.getElementById("warriorActionBtn").setAttribute("disabled","disabled");
    document.getElementById("mageActionBtn").setAttribute("disabled","disabled");
    document.getElementById("healerActionBtn").setAttribute("disabled","disabled");
  }

  healerAction(){
    console.log("healerAction()");
    document.getElementById("healerActionBtn").setAttribute('style', 'background-color: grey');
    this.currentHero = this.healer.name;
    console.log(this.playerList);
    document.getElementById("warriorActionBtn").setAttribute("disabled","disabled");
    document.getElementById("mageActionBtn").setAttribute("disabled","disabled");
    document.getElementById("guardActionBtn").setAttribute("disabled","disabled");
  }



  goblinFn1(){
    console.log("goblinFn1()");
    let heroNum = this.findHero(this.currentHero);
    console.log("heroNum: " + heroNum);
    this.playerList[heroNum].targets = [4];
    this.currentHero = "";
    console.log("Updated Hero: " + this.playerList[heroNum]);
    this.allReady[heroNum] = true;
    this.checkAllReady(this.allReady);
    document.getElementById("warriorActionBtn").removeAttribute("disabled");
    document.getElementById("mageActionBtn").removeAttribute("disabled");
    document.getElementById("guardActionBtn").removeAttribute("disabled");
    document.getElementById("healerActionBtn").removeAttribute("disabled");
  }


  goblinFn2(){
    console.log("goblinFn2()");
    let heroNum = this.findHero(this.currentHero);
    console.log("heroNum: " + heroNum);
    this.playerList[heroNum].targets = [5];
    this.currentHero = "";
    console.log("Updated Hero: " + this.playerList[heroNum]);
    this.allReady[heroNum] = true;
    this.checkAllReady(this.allReady);
    document.getElementById("warriorActionBtn").removeAttribute("disabled");
    document.getElementById("mageActionBtn").removeAttribute("disabled");
    document.getElementById("guardActionBtn").removeAttribute("disabled");
    document.getElementById("healerActionBtn").removeAttribute("disabled");
  }
  
  goblinFn3(){
    console.log("goblinFn3()");
    let heroNum = this.findHero(this.currentHero);
    console.log("heroNum: " + heroNum);
    this.playerList[heroNum].targets = [6];
    this.currentHero = "";
    console.log("Updated Hero: " + this.playerList[heroNum]);
    this.allReady[heroNum] = true;
    this.checkAllReady(this.allReady);
    document.getElementById("warriorActionBtn").removeAttribute("disabled");
    document.getElementById("mageActionBtn").removeAttribute("disabled");
    document.getElementById("guardActionBtn").removeAttribute("disabled");
    document.getElementById("healerActionBtn").removeAttribute("disabled");
  }

  goblinFn4(){
    console.log("goblinFn4()");
    let heroNum = this.findHero(this.currentHero);
    console.log("heroNum: " + heroNum);
    this.playerList[heroNum].targets = [7];
    this.currentHero = "";
    console.log("Updated Hero: " + this.playerList[heroNum]);
    this.allReady[heroNum] = true;
    this.checkAllReady(this.allReady);
    document.getElementById("warriorActionBtn").removeAttribute("disabled");
    document.getElementById("mageActionBtn").removeAttribute("disabled");
    document.getElementById("guardActionBtn").removeAttribute("disabled");
    document.getElementById("healerActionBtn").removeAttribute("disabled");
  }

  checkAllReady(allReady){
    console.log("checkAllReady(allReady)");
    // Make the submit button selectable once all heroes took their turns
    if(allReady[0] == true &&
      allReady[1] == true &&
      allReady[2] == true &&
      allReady[3] == true) {
        document.getElementById("submitBtn").removeAttribute("disabled");
    }
  }

  findHero(currentHero: string) {
    console.log("findHero(currentHero: string)");
    if(currentHero === "warrior"){
      return 0;
    } else if(currentHero === "mage"){
      return 1;
    } else if(currentHero === "guard"){
      return 2;
    } else if(currentHero === "healer"){
      return 3;
    }
  }
}
