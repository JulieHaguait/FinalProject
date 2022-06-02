import { Routes } from '@angular/router';
import { InscriptionComponent } ;



export const routes: Routes = [
    { path: 'home', component:  },
    { path: 'admin', component:  },
    { path: 'skykid', component: },
    path: 'inscription', component: InscriptionComponent, canActivate: [AnonymousService],},


    { path: 'login', component: LoginComponent, canActivate: [AnonymousService] },
  { path: '', redirectTo: 'home', pathMatch: 'full' },



]
