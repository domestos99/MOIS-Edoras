import { NgModule, Optional, SkipSelf } from '@angular/core';
import { HttpClientModule, HTTP_INTERCEPTORS } from '@angular/common/http';

import { AuthGuard } from './guards/auth.guard';
import { NoAuthGuard } from './guards/no-auth.guard';


import { TokenInterceptor } from './interceptors/token.interceptor';

import { throwIfAlreadyLoaded } from './guards/module-import.guard';
import {NavigationselperService} from "@app/core/helpers";

@NgModule({
  imports: [
    HttpClientModule,
  ],
  providers: [
    AuthGuard,
    NoAuthGuard,

    {
      provide: HTTP_INTERCEPTORS,
      useClass: TokenInterceptor,
      multi: true
    },
    NavigationselperService
  ]
})
export class CoreModule {
  constructor(@Optional() @SkipSelf() parentModule: CoreModule) {
    throwIfAlreadyLoaded(parentModule, 'CoreModule');
  }
}
