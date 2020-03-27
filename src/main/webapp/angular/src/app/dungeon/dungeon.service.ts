import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Player } from '../player-declaration';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class DungeonService {

  constructor(private http: HttpClient) { }

  url = "http://localhost:8080/project2/dungeon";

  httpOptions = {
    headers: new HttpHeaders({ 'Content-Type': 'application/json' })
  };

  //action: {[k: string]: any} = {};

  getPlayer(): Observable <Player[]> {
    return this.http.get<Player[]>(this.url);
  }

  submitFunc(playerList: Player[]){
    console.log(JSON.stringify(playerList) + " action on submit")
    this.http.post(this.url, playerList);
  }

  attack (player: Player){
    //console.log(player);
    //this.submitFunc(player)
  }




}

