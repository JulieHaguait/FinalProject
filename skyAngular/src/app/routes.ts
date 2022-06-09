import { HomeComponent } from './components/home/home.component';
import { InscriptionComponent } from './components/free-for-all/inscription/inscription.component';
import { ConnexionComponent } from './components/free-for-all/connexion/connexion.component';
import { Routes } from '@angular/router';
import { AnonymousService } from './services/anonymous.service';
import { InscriptionSuccessComponent } from './components/free-for-all/inscription-success/inscription-success.component';
import { ProfilAdminComponent } from './components/connected/profil-admin/profil-admin.component';
import { ProfilSkykidComponent } from './components/connected/profil-skykid/profil-skykid.component';
import { IleComponent } from './components/connected/skykid/realm/ile/ile.component';
import { PrairieComponent } from './components/connected/skykid/realm/prairie/prairie.component';
import { ForetComponent } from './components/connected/skykid/realm/foret/foret.component';
import { ValleeComponent } from './components/connected/skykid/realm/vallee/vallee.component';
import { DesertComponent } from './components/connected/skykid/realm/desert/desert.component';
import { ChambreComponent } from './components/connected/skykid/realm/chambre/chambre.component';
import { BbComponent } from './components/connected/skykid/monnaie/bb/bb.component';
import { BrComponent } from './components/connected/skykid/monnaie/br/br.component';
import { CoeurComponent } from './components/connected/skykid/monnaie/coeur/coeur.component';
import { CoiffeComponent } from './components/connected/skykid/inventaire/coiffe/coiffe.component';
import { PantalonComponent } from './components/connected/skykid/inventaire/pantalon/pantalon.component';
import { CapeComponent } from './components/connected/skykid/inventaire/cape/cape.component';
import { ChapeauComponent } from './components/connected/skykid/inventaire/chapeau/chapeau.component';
import { ListSkykidComponent } from './components/connected/admin/list-skykid/list-skykid.component';
import { EditSkykidComponent } from './components/connected/admin/edit-skykid/edit-skykid.component';
import { GestionBoutiqueComponent } from './components/connected/admin/gestion-boutique/gestion-boutique.component';

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
  { path: 'profil-admin/list-skykid', component: ListSkykidComponent },
  { path: 'profil-admin/edit-skykid', component: EditSkykidComponent },
  { path: 'profil-admin/edit-skykid/:id', component: EditSkykidComponent },
  {
    path: 'profil-admin/gestion-boutique',
    component: GestionBoutiqueComponent,
  },

  {
    path: 'profil-skykid',
    component: ProfilSkykidComponent,
  },
  {
    path: 'ile',
    component: IleComponent,
  },
  {
    path: 'prairie',
    component: PrairieComponent,
  },
  {
    path: 'foret',
    component: ForetComponent,
  },
  {
    path: 'vallee',
    component: ValleeComponent,
  },
  {
    path: 'desert',
    component: DesertComponent,
  },
  {
    path: 'chambre',
    component: ChambreComponent,
  },
  {
    path: 'bb',
    component: BbComponent,
  },
  {
    path: 'br',
    component: BrComponent,
  },
  {
    path: 'coeur',
    component: CoeurComponent,
  },
  {
    path: 'coiffe',
    component: CoiffeComponent,
  },
  {
    path: 'pantalon',
    component: PantalonComponent,
  },
  {
    path: 'cape',
    component: CapeComponent,
  },
  {
    path: 'chapeau',
    component: ChapeauComponent,
  },

  // { path: 'login', component: LoginComponent, canActivate: [AnonymousService] },
  { path: '', redirectTo: 'home', pathMatch: 'full' },
];
