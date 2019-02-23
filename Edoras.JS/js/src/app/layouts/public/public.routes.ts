import {Routes, RouterModule} from '@angular/router';
import {LoginComponent} from "@app/modules/public/login/login.component";
import {PaymentComponent} from "@app/modules/secure/payment/payment.component";


export const PUBLIC_ROUTES: Routes = [
  {path: '', redirectTo: '', pathMatch: 'full'},
  {path: 'login', component: LoginComponent}
];
