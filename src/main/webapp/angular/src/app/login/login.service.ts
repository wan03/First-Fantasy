import { Injectable } from "@angular/core";
import { User } from "../user-class";
import { USER } from "../mock-users";
import { HttpClient, HttpHeaders } from '@angular/common/http';
import {Router} from "@angular/router"
import { LoginComponent } from "./login.component";
import { Observable, of } from "rxjs";

@Injectable({
  providedIn: "root"
})
export class LoginService {
  constructor(private http: HttpClient, private router: Router) {}

  url = "http://localhost:8080/project2/login";

  valid;

  httpOptions = {
    headers: new HttpHeaders({ 'Content-Type': 'application/json' })
  };

  isValid(){
    if (this.valid){
      return true
    } else{
      return false;
    }

  }

  sendLogin(user: User): void {
    console.log("sendLogin(User)");

    this.http.post(this.url, user).subscribe((user:User) => {
      if (user){
        this.valid = true;
        this.router.navigate(["/dungeon", user]);
      }
    })

  }

  putInfo(registrationForm){
    console.log(JSON.stringify(registrationForm) + " JSON to PUT")
    this.http.put(this.url, registrationForm);
  }

  // sendLogin(user: User): void {
  //   console.log("sendLogin(User)");
  //   // This is where the post statement will go.
  //   // The server should redirect to the main menu page.
  //   if (this.authenticate(user)) {
  //     console.log("Match");
  //   } else {
  //     console.log("No Match");
  //   }
  // }

  // authenticate(user: User): boolean {
  //   console.log("authenticate(User)");
  //   return USER.username === user.username && USER.password === user.password;
  // }
}
