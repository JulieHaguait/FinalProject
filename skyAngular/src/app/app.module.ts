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
import { EditAdminComponent } from './components/connected/admin/edit-admin/edit-admin.component';

import { ListAdminComponent } from './components/connected/admin/list-admin/list-admin.component';

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
    EditAdminComponent,

    ListAdminComponent,
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
