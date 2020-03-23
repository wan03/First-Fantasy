import { Injectable } from "@angular/core";
import { User } from "../user-class";
import { USER } from "../mock-users";
import { LoginComponent } from "./login.component";
import { Observable, of } from "rxjs";

@Injectable({
  providedIn: "root"
})
export class LoginService {
  constructor() {}

  sendLogin(user: User): void {
    console.log("sendLogin(User)");
    // This is where the post statement will go.
    // The server should redirect to the main menu page.
    if (this.authenticate(user)) {
      console.log("Match");
    } else {
      console.log("No Match");
    }
  }

  authenticate(user: User): boolean {
    // TODO: Must authenticate on server-side. Completely delete.
    console.log("authenticate(User)");
    return USER.username === user.username && USER.password === user.password;
  }
}
