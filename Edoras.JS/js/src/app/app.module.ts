import {BrowserModule} from '@angular/platform-browser';
import {NgModule} from '@angular/core';

import {CoreModule} from '@app/core';
import {SharedModule} from '@app/shared';

import {AppComponent} from './app.component';


// import {AuthModule} from './modules/auth/auth.module';
import {BrowserAnimationsModule} from '@angular/platform-browser/animations';
import {RouterModule} from '@angular/router';
import {DashboardComponent} from "@app/modules/secure/dashboard/dashboard.component";
import {PaymentListComponent} from "@app/modules/secure/payment/list/payment-list.component";
import {PaymentComponent} from "@app/modules/secure/payment/payment.component";
import {PaymentDetailComponent} from "@app/modules/secure/payment/detail/payment-detail.component";
import {AppRoutingModule} from "@app/app.routing";
import {NavigationComponent} from "@app/layouts/secure/navigation/navigation.component";
import {LoginComponent} from "@app/modules/public/login/login.component";
import {SecureComponent} from "@app/layouts/secure/secure.component";
import {PublicComponent} from "@app/layouts/public/public.component";
import {PageNotFoundComponent} from "@app/modules/secure/errorpages/page-not-found.component";
import {NavigationService} from "@app/layouts/secure/navigation/navigation.service";
import {PaymentService} from "@app/modules/secure/payment/payment.service";
import {AlertService, AuthenticationService} from "@app/core/auth";
import {HTTP_INTERCEPTORS} from "@angular/common/http";
import {ErrorInterceptor, TokenInterceptor} from "@app/core/interceptors";
import {PaymentListItemComponent} from "@app/modules/secure/payment/list/payment-list-item.component";
import {CategorySelectComponent} from "@app/modules/secure/category/category-select/category-select.component";
import {TransactionComponent} from "@app/modules/secure/transaction/transaction.component";
import {TransactionListComponent} from "@app/modules/secure/transaction/list/transaction-list.component";
import {TransactionDetailComponent} from "@app/modules/secure/transaction/detail/transaction-detail.component";
import {TransactionListItemComponent} from "@app/modules/secure/transaction/list/transaction-list-item.component";
import {TransactionService} from "@app/modules/secure/transaction/transaction.service";
import {CategoryComponent} from "@app/modules/secure/category/category.component";
import {CategoryListComponent} from "@app/modules/secure/category/list/category-list.component";
import {CategoryService} from "@app/modules/secure/category/category.service";
import {PaymentCategoryService} from "@app/core/services/paymentCategory.service";
import {CategoryCreateComponent} from "@app/modules/secure/category/category-create/category-create.component";


@NgModule({
  declarations: [
    AppComponent,

    LoginComponent,
    DashboardComponent,

    PaymentComponent,
    PaymentListComponent,
    PaymentListItemComponent,
    PaymentDetailComponent,
    CategorySelectComponent,
    CategoryComponent,
    CategoryListComponent,
    CategoryCreateComponent,
    TransactionComponent,
    TransactionListComponent,
    TransactionDetailComponent,
    TransactionListItemComponent,
    NavigationComponent,
    PublicComponent,
    SecureComponent,
    PageNotFoundComponent,


  ],
  imports: [

    // angular
    BrowserModule,

    // 3rd party
    // AuthModule,

    // core & shared
    CoreModule,
    SharedModule,
    // DevExpressModule,


    RouterModule,

    // app
    AppRoutingModule,

    BrowserAnimationsModule


  ],
  entryComponents:
    [
      CategoryCreateComponent

    ],
  providers: [

    NavigationService,
    AuthenticationService,
    AlertService,
    PaymentService,
    TransactionService,
    CategoryService,
    PaymentCategoryService,

    {provide: HTTP_INTERCEPTORS, useClass: TokenInterceptor, multi: true},
    {provide: HTTP_INTERCEPTORS, useClass: ErrorInterceptor, multi: true},


  ],
  bootstrap: [AppComponent]
})
export class AppModule {
}
