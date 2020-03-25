import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-dungeon',
  templateUrl: './dungeon.component.html',
  styleUrls: ['./dungeon.component.css']
})
export class DungeonComponent implements OnInit {

  constructor() { }

  ngOnInit(): void {
    document.getElementById("submitBtn").setAttribute("disabled", "true");
  }

  warriorAction(){

  }

  mageAction(){
    
  }

  guardAction(){
    
  }

  healerAction(){
    
  }

  submitFunc(){
    
  }
}
