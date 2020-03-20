import { Component, OnInit, Input, Testability } from '@angular/core';
import { User } from '../user-class';
import { USER } from '../mock-users';
import { LoginService } from './login.service';

@Component({
  selector: 'app-login',
  template: `
              <input type="text" class="form-control" (key)="username"/>
              <br>
              <input type="password" class="form-control" (key)="password"/>
              <br>
              <button (click)="getLogin($event)">Login</button>
            `,
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
  constructor(private loginService: LoginService) { }
  ngOnInit(): void {
  }

  // Variables
  u: User = {
    username: '',
    password: ''
  };
  

  // Methods
  sendLogin(): void{
    this.loginService.authenticate(this.u);
  }
}
