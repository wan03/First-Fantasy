import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { FormGroup } from '@angular/forms';

@Injectable({
  providedIn: 'root'
})
export class RegistrationFormService {
  constructor(private http: HttpClient) { }

  url = "http://localhost:8080/project2/register";
  httpOptions = {
    headers: new HttpHeaders({ 'Content-Type': 'application/json' })
  };

  putInfo(registrationForm: FormGroup){
    console.log(JSON.stringify(registrationForm) + " JSON to PUT")
    this.http.put(this.url, registrationForm);
  }
}
