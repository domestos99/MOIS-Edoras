import {BrowserModule} from '@angular/platform-browser';
import {NgModule} from '@angular/core';

import {CoreModule} from '@app/core';
import {SharedModule} from '@app/shared';

import {AppComponent} from './app.component';


// import {AuthModule} from './modules/auth/auth.module';
import {BrowserAnimationsModule} from '@angular/platform-browser/animations';
import {RouterModule} from '@angular/router';
import {DashboardComponent} from "@app/modules/secure/dashboard/dashboard.component";
import {TestComponent} from "@app/modules/secure/test/test.component";
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


@NgModule({
  declarations: [
    AppComponent,

    LoginComponent,
    DashboardComponent,
    TestComponent,
    PaymentComponent,
    PaymentListComponent,
    PaymentDetailComponent,
    CategoryComponent,
    CategoryListComponent,
    CategoryDetailComponent,
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
    [],
  providers: [

    NavigationService,
    AuthenticationService,
    AlertService,
    PaymentService,
    CategoryService,

    {provide: HTTP_INTERCEPTORS, useClass: TokenInterceptor, multi: true},
    {provide: HTTP_INTERCEPTORS, useClass: ErrorInterceptor, multi: true},


  ],
  bootstrap: [AppComponent]
})
export class AppModule {
}
