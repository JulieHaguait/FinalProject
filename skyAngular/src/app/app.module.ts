import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { RouterModule } from '@angular/router';
import { HttpClientModule, HTTP_INTERCEPTORS } from '@angular/common/http';

import { AppComponent } from './app.component';
import { routes } from './routes';

import { InscriptionComponent } from './components/free-for-all/inscription/inscription.component';
import { ConnexionComponent } from './components/free-for-all/connexion/connexion.component';
import { MenuComponent } from './components/menu/menu.component';
import { HomeComponent } from './components/home/home.component';
import { InscriptionSuccessComponent } from './components/free-for-all/inscription-success/inscription-success.component';
import { AuthInterceptor } from './interceptors/auth-interceptor';
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

@NgModule({
  declarations: [
    AppComponent,
    InscriptionComponent,
    ConnexionComponent,
    MenuComponent,
    HomeComponent,
    InscriptionSuccessComponent,
    ProfilAdminComponent,
    ProfilSkykidComponent,
    IleComponent,
    PrairieComponent,
    ForetComponent,
    ValleeComponent,
    DesertComponent,
    ChambreComponent,
    BrComponent,
    BbComponent,
    CoeurComponent,
    CoiffeComponent,
    CapeComponent,
    PantalonComponent,
    ChapeauComponent,
    ListSkykidComponent,
    EditSkykidComponent,
  ],

  imports: [
    BrowserModule,
    HttpClientModule,
    RouterModule.forRoot(routes),
    FormsModule,
    ReactiveFormsModule,
  ],
  providers: [
    { provide: HTTP_INTERCEPTORS, useClass: AuthInterceptor, multi: true },
  ],
  bootstrap: [AppComponent],
})
export class AppModule {}
