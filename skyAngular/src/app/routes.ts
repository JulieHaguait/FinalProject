import { HomeComponent } from './components/home/home.component';
import { InscriptionComponent } from './components/free-for-all/inscription/inscription.component';
import { ConnexionComponent } from './components/free-for-all/connexion/connexion.component';
import { Routes } from '@angular/router';
import { AnonymousService } from './services/anonymous.service';


export const routes: Routes = [
    { path: 'home', component:  HomeComponent},
   // { path: 'admin', component:  },
   // { path: 'skykid', component: },
    { path: 'inscription', component: InscriptionComponent, canActivate: [AnonymousService],},
    { path: 'connexion', component: ConnexionComponent, canActivate: [AnonymousService],},


   // { path: 'login', component: LoginComponent, canActivate: [AnonymousService] },
 // { path: '', redirectTo: 'home', pathMatch: 'full' },



]
