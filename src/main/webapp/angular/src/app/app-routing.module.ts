import { NgModule } from "@angular/core";
import { Routes, RouterModule } from "@angular/router";
import { MainMenuComponent } from "./main-menu/main-menu.component";
import { LoginComponent } from "./login/login.component";
import { RegistrationFormComponent } from "./registration-form/registration-form.component";
import { HomePageComponent } from "./home-page/home-page.component";

const routes: Routes = [
  { path: "menu", component: MainMenuComponent },
  { path: "login", component: LoginComponent },
  { path: "register", component: RegistrationFormComponent },
  { path: "", component: HomePageComponent, pathMatch: "full" }

  // {path: '', redirectTo: '/login', pathMatch: 'full'}
  //{path: '**', redirectTo: '/login', pathMatch: 'full'} // If path doesn't exist, reroute to landing page.
  //{path: '**', component: LoginComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule {}
