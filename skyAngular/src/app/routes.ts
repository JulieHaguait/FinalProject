import { HomeComponent } from './components/home/home.component';
import { InscriptionComponent } from './components/free-for-all/inscription/inscription.component';
import { ConnexionComponent } from './components/free-for-all/connexion/connexion.component';
import { Routes } from '@angular/router';
import { AnonymousService } from './services/anonymous.service';
import { InscriptionSuccessComponent } from './components/free-for-all/inscription-success/inscription-success.component';
import { ProfilAdminComponent } from './components/connected/profil-admin/profil-admin.component';
import { ProfilSkykidComponent } from './components/connected/profil-skykid/profil-skykid.component';

export const routes: Routes = [
  { path: 'home', component: HomeComponent },
  // { path: 'admin', component:  },
  // { path: 'skykid', component: },
  {
    path: 'inscription',
    component: InscriptionComponent,
    canActivate: [AnonymousService],
  },
  {
    path: 'connexion',
    component: ConnexionComponent,
    canActivate: [AnonymousService],
  },

  {
    path: 'inscription-success',
    component: InscriptionSuccessComponent,
    canActivate: [AnonymousService],
  },
  {
    path: 'profil-admin',
    component: ProfilAdminComponent,
  },
  {
    path: 'profil-skykid',
    component: ProfilSkykidComponent,
  },

  // { path: 'login', component: LoginComponent, canActivate: [AnonymousService] },
  { path: '', redirectTo: 'home', pathMatch: 'full' },
];
