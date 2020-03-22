import { BrowserModule } from "@angular/platform-browser";
import { NgModule } from "@angular/core";
import { FormsModule, ReactiveFormsModule } from "@angular/forms";
import { AppRoutingModule } from "./app-routing.module";
import { NgbModule } from "@ng-bootstrap/ng-bootstrap";
import { AppComponent } from "./app.component";
import { HttpClientModule } from "@angular/common/http";
import { LoginComponent } from "./login/login.component";
import { LoginService } from "./login/login.service";
import { MainMenuComponent } from "./main-menu/main-menu.component";
import { NavbarComponent } from "./navbar/navbar.component";
import { CarouselComponent } from "./carousel/carousel.component";
import { RegistrationFormComponent } from "./registration-form/registration-form.component";

@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    MainMenuComponent,
    NavbarComponent,
    CarouselComponent,
    RegistrationFormComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule,
    ReactiveFormsModule,
    NgbModule
  ],
  providers: [],
  // LoginService
  bootstrap: [AppComponent]
})
export class AppModule {}
