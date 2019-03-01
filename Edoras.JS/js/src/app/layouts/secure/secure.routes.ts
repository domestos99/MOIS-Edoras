import {Routes, RouterModule} from '@angular/router';
import {AuthGuard} from "@app/core";
import {PaymentComponent} from "@app/modules/secure/payment/payment.component";
import {DashboardComponent} from "@app/modules/secure/dashboard/dashboard.component";
import {PaymentDetailComponent} from "@app/modules/secure/payment/detail/payment-detail.component";
import {TransactionComponent} from "@app/modules/secure/transaction/transaction.component";
import {TransactionDetailComponent} from "@app/modules/secure/transaction/detail/transaction-detail.component";
import {CategoryComponent} from "@app/modules/secure/category/category.component";
import {CategoryDetailComponent} from "@app/modules/secure/category/detail/category-detail.component";

export const SECURE_ROUTES: Routes = [

  {path: '', redirectTo: '', pathMatch: 'full'},
  {path: '', component: DashboardComponent, canActivate: [AuthGuard]},
  {path: 'dashboard', component: DashboardComponent, canActivate: [AuthGuard]},
  {path: 'payments', component: PaymentComponent, canActivate: [AuthGuard]},
  {path: 'payments/:id', component: PaymentDetailComponent, canActivate: [AuthGuard]},
  {path: 'categories', component: CategoryComponent, canActivate: [AuthGuard]},
  {path: 'category/:id', component: CategoryDetailComponent, canActivate: [AuthGuard]},
  {path: 'transactions', component: TransactionComponent, canActivate: [AuthGuard]},
  {path: 'transactions/:id', component: TransactionDetailComponent, canActivate: [AuthGuard]},
];
