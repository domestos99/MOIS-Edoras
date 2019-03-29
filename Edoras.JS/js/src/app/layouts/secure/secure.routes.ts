import {Routes, RouterModule} from '@angular/router';
import {AuthGuard} from "@app/core";
import {PaymentComponent} from "@app/modules/secure/payment/payment.component";
import {DashboardComponent} from "@app/modules/secure/dashboard/dashboard.component";
import {TransactionComponent} from "@app/modules/secure/transaction/transaction.component";
import {CategoryComponent} from "@app/modules/secure/category/category.component";
import {AdminComponent} from "@app/modules/secure/admin/admin.component";

export const SECURE_ROUTES: Routes = [

  {path: '', redirectTo: '', pathMatch: 'full'},
  {path: '', component: DashboardComponent, canActivate: [AuthGuard]},
  {path: 'dashboard', component: DashboardComponent, canActivate: [AuthGuard]},
  {path: 'payments', component: PaymentComponent, canActivate: [AuthGuard]},
  {path: 'categories', component: CategoryComponent, canActivate: [AuthGuard]},
  {path: 'transactions', component: TransactionComponent, canActivate: [AuthGuard]},
  {path: 'admin', component: AdminComponent, canActivate: [AuthGuard]},
];
