import { Injectable } from '@angular/core';
import { User } from '../user-class';
import { USER } from '../mock-users';
import { LoginComponent } from './login.component';
import { Observable, of } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class LoginService {
  constructor() { }

  authenticate(user: User): void {
    console.log("sendLogin(User)");
    if(USER.username === user.username &&
       USER.password === user.password){
      console.log("Match");
    } else {
      console.log("No Match");
    }
  }
}
