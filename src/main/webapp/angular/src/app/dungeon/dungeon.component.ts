import { Component, OnInit } from '@angular/core';
import { DungeonService } from './dungeon.service';
import { Player, Dto } from '../player-declaration';
import { DTO, PLAYER,PLAYER1,PLAYER2,PLAYER3, } from '../mock-player';
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
    //this.dungeonService.getDto().subscribe(playerList => this.playerList = playerList);
    this.dungeonService.getInitPlayerList().subscribe(playerList => {
    this.playerList = playerList;
    this.playerList[4].ready = true;
    this.playerList[5].ready = true;
    this.playerList[6].ready = true;
    this.playerList[7].ready = true;
    });

    this.warrior.name = "warrior";
    this.mage.name = "mage";
    this.guard.name = "guard";
    this.healer.name = "healer";

  }

  dto: Dto = DTO;
  currentHero: string = "";
  allReady = [false,false,false,false];


  // Get hero info
  warrior: Player = PLAYER;
  mage: Player = PLAYER1;
  guard: Player = PLAYER2;
  healer: Player = PLAYER3;
  playerList: Player[] = [this.warrior, this.mage, this.guard, this.healer];
                          //this.warrior, this.mage, this.guard, this.healer];

  


  submitFunc(){
    console.log("submitFunc()");
    this.dto.characters = this.playerList;
    this.dto.log = "";
    this.dto.status = 0;
    //this.dungeonService.postPlayerList(this.playerList);
    this.dungeonService.postDto(this.dto).subscribe(data => {
      this.dto = data;
      this.playerList = this.dto.characters;
      document.getElementById("combatLogSection").innerHTML = this.dto.log;
      if(this.dto.status === 1){
        alert("YOU WIN")
      } else if(this.dto.status === -1){
        alert("YOU LOSE")
      } else {
        document.getElementById("submitBtn").setAttribute("disabled", "");

        document.getElementById("warriorActionBtn").setAttribute('style', 'background-color: blue; max-width: 8rem;');
        document.getElementById("mageActionBtn").setAttribute('style', 'background-color: blue; max-width: 8rem;');
        document.getElementById("guardActionBtn").setAttribute('style', 'background-color: blue; max-width: 8rem;');
        document.getElementById("healerActionBtn").setAttribute('style', 'background-color: blue; max-width: 8rem;');

        document.getElementById("warriorActionBtn").removeAttribute("disabled");
        document.getElementById("mageActionBtn").removeAttribute("disabled");
        document.getElementById("guardActionBtn").removeAttribute("disabled");
        document.getElementById("healerActionBtn").removeAttribute("disabled");

        this.playerList[4].ready = true;
        this.playerList[5].ready = true;
        this.playerList[6].ready = true;
        this.playerList[7].ready = true;

        this.allReady = [false,false,false,false];
      }

    });
  }


  warriorAction(){
    console.log("warriorAction()");
    console.log("warrior = " + this.warrior);
    document.getElementById("warriorActionBtn").setAttribute('style', 'background-color: grey; max-width: 8rem;');
    this.currentHero = this.warrior.name;
    console.log(this.playerList);
    document.getElementById("mageActionBtn").setAttribute("disabled","disabled");
    document.getElementById("guardActionBtn").setAttribute("disabled","disabled");
    document.getElementById("healerActionBtn").setAttribute("disabled","disabled");
  }

  mageAction(){
    console.log("mageAction()");
    document.getElementById("mageActionBtn").setAttribute('style', 'background-color: grey; max-width: 8rem;');
    this.currentHero = this.mage.name;
    console.log(this.playerList);
    document.getElementById("warriorActionBtn").setAttribute("disabled","disabled");
    document.getElementById("guardActionBtn").setAttribute("disabled","disabled");
    document.getElementById("healerActionBtn").setAttribute("disabled","disabled");
  }

  guardAction(){
    console.log("guardAction()");
    document.getElementById("guardActionBtn").setAttribute('style', 'background-color: grey; max-width: 8rem;');
    this.currentHero = this.guard.name;
    console.log(this.playerList);
    document.getElementById("warriorActionBtn").setAttribute("disabled","disabled");
    document.getElementById("mageActionBtn").setAttribute("disabled","disabled");
    document.getElementById("healerActionBtn").setAttribute("disabled","disabled");
  }

  healerAction(){
    console.log("healerAction()");
    document.getElementById("healerActionBtn").setAttribute('style', 'background-color: grey; max-width: 8rem;');
    this.currentHero = this.healer.name;
    console.log(this.playerList);
    document.getElementById("warriorActionBtn").setAttribute("disabled","disabled");
    document.getElementById("mageActionBtn").setAttribute("disabled","disabled");
    document.getElementById("guardActionBtn").setAttribute("disabled","disabled");
  }



  goblinFn1(){
    console.log("goblinFn1()");
    console.log(this.playerList[4]);
    let heroNum = this.findHero(this.currentHero);
    console.log("heroNum: " + heroNum);
    this.playerList[heroNum].targets = [4];
    this.playerList[heroNum].ready = true;
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
    console.log(this.playerList[5]);
    let heroNum = this.findHero(this.currentHero);
    console.log("heroNum: " + heroNum);
    this.playerList[heroNum].targets = [5];
    this.playerList[heroNum].ready = true;
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
    console.log(this.playerList[6]);
    let heroNum = this.findHero(this.currentHero);
    console.log("heroNum: " + heroNum);
    this.playerList[heroNum].targets = [6];
    this.playerList[heroNum].ready = true;
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
    console.log(this.playerList[7]);
    let heroNum = this.findHero(this.currentHero);
    console.log("heroNum: " + heroNum);
    this.playerList[heroNum].targets = [7];
    this.playerList[heroNum].ready = true;
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
