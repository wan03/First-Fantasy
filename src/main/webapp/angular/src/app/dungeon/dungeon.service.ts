import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Player,Dto } from '../player-declaration';
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

  getInitPlayerList(): Observable <Player[]> {
    return this.http.get<Player[]>(this.url);
  }

  postDto(dto: Dto): Observable <Dto> {
    //return this.http.post<Dto>(this.url);
    // dto: Dto;
    // this.dungeonComponent.dto = dto
    //this.http.post(this.url, dto).subscribe(data => {return data;});
    return this.http.post<Dto>(this.url, dto);
  }

  // postPlayerList(playerList: Player[]){
  //   //console.log(JSON.stringify(playerList) + " JSON to POST")
  //   //this.http.post(this.url, playerList).subscribe(data => playerList = data);
  //   this.http.post(this.url, playerList).subscribe();
  // }
  // postPlayerList(PLAYER){
  //   console.log(JSON.stringify(PLAYER) + " JSON to POST")
  //   this.http.post(this.url, PLAYER);
  // }

  //attack (player: Player){
    //console.log(player);
    //this.submitFunc(player)
  //}

//   public clone(): any {
//     let cloneObj = new (<any>this.constructor());
//     for (let attribut in this) {
//         if (typeof this[attribut] === "object") {
//             cloneObj[attribut] = this[attribut].clone();
//         } else {
//             cloneObj[attribut] = this[attribut];
//         }
//     }
//     return cloneObj;
// }



}

