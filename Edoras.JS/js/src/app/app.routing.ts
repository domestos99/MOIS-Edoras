import {NgModule} from '@angular/core';
import {Routes, RouterModule, PreloadAllModules} from '@angular/router';

import {AuthGuard, NoAuthGuard} from '@app/core';
import {PublicComponent} from "@app/layouts/public/public.component";
import {PUBLIC_ROUTES} from "@app/layouts/public/public.routes";
import {SecureComponent} from "@app/layouts/secure/secure.component";
import {SECURE_ROUTES} from "@app/layouts/secure/secure.routes";

const routes: Routes = [
  {
    path: '', redirectTo: '/dashboard', pathMatch: 'full'
  },
  {
    path: '', component: PublicComponent, data: {title: 'Public Views'}, children: PUBLIC_ROUTES
  },
  {
    path: '',
    component: SecureComponent,
    canActivate: [AuthGuard],
    data: {title: 'Secure Views'},
    children: SECURE_ROUTES
  },
  {
    path: '**', redirectTo: ''
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes, {
    // useHash: true,
    //  enableTracing: true
  })],
  exports: [RouterModule],
  providers: []
})
export class AppRoutingModule {
}

