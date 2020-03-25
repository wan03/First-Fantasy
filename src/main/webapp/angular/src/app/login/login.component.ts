import { Component, OnInit, Input, Testability } from "@angular/core";
import { FormGroup, FormControl, Validators } from "@angular/forms";
import { User } from "../user-class";
import { USER } from "../mock-users";
import { LoginService } from "./login.service";

@Component({
  selector: "app-login",
  templateUrl: "./login.component.html",
  styleUrls: ["./login.component.css"]
})
export class LoginComponent implements OnInit {
  constructor(private loginService: LoginService) {}
  ngOnInit(): void {}

  // Variables
  loginForm = new FormGroup({
    email: new FormControl("", [Validators.required, Validators.email]),
    password: new FormControl("", Validators.required)
  });

  get email() {
    return this.loginForm.get("email");
  }
  get password() {
    return this.loginForm.get("password");
  }

  // Methods
  sendLogin(): void {
    let email = <unknown>this.loginForm.get("email");
    let password = <unknown>this.loginForm.get("password");
    let u: User = {
      username: "",
      password: ""
    };
    u.username = <string>email;
    u.password = <string>password;
    this.loginService.sendLogin(u);
  }
}
