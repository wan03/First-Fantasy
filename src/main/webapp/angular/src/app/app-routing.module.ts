import { NgModule } from "@angular/core";
import { Routes, RouterModule } from "@angular/router";
import { MainMenuComponent } from "./main-menu/main-menu.component";
import { LoginComponent } from "./login/login.component";
import { RegistrationFormComponent } from "./registration-form/registration-form.component";
import { DungeonComponent } from "./dungeon/dungeon.component";
import { HomePageComponent } from "./home-page/home-page.component";
import { AuthGuard } from "./auth/auth.guard";

const routes: Routes = [
  { path: "menu", component: MainMenuComponent },
  { path: "login", component: LoginComponent },
  { path: "register", component: RegistrationFormComponent },
  { path: "dungeon", component: DungeonComponent, canActivate: [AuthGuard] },
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
