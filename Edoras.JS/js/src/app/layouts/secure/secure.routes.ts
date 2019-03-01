import {Routes, RouterModule} from '@angular/router';
import {AuthGuard} from "@app/core";
import {PaymentComponent} from "@app/modules/secure/payment/payment.component";
import {DashboardComponent} from "@app/modules/secure/dashboard/dashboard.component";
import {TestComponent} from "@app/modules/secure/test/test.component";

export const SECURE_ROUTES: Routes = [

  {path: '', redirectTo: '', pathMatch: 'full'},
  {path: '', component: DashboardComponent, canActivate: [AuthGuard]},
  {path: 'dashboard', component: DashboardComponent, canActivate: [AuthGuard]},
  {path: 'payments', component: PaymentComponent, canActivate: [AuthGuard]},
  {path: 'payments/:id', component: PaymentDetailComponent, canActivate: [AuthGuard]},
  {path: 'categories', component: CategoryComponent, canActivate: [AuthGuard]},
  {path: 'test', component: TestComponent, canActivate: [AuthGuard]}
];
