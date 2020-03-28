import { Injectable } from "@angular/core";
import { User } from "../user-class";
import { USER } from "../mock-users";
import { HttpClient, HttpHeaders } from '@angular/common/http';

@Injectable({
  providedIn: "root"
})
export class LoginService {
  constructor(private http: HttpClient) { }

  url = "http://localhost:8080/project2/login";
  httpOptions = {
    headers: new HttpHeaders({ 'Content-Type': 'application/json' })
  };

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
