import {Injectable} from '@angular/core';
import {ActivatedRouteSnapshot, CanActivate, Router, RouterStateSnapshot} from '@angular/router';

@Injectable()
export class AuthGuard implements CanActivate {

  constructor(private router: Router) {

  }

  // https://stackblitz.com/edit/angular-6-registration-login-example?file=app%2F_helpers%2Fjwt.interceptor.ts

  canActivate(route: ActivatedRouteSnapshot, state: RouterStateSnapshot): boolean {
    if (localStorage.getItem('currentUser')) {
      // logged in so return true
      return true;
    }

    //  not logged in so redirect to login page
    this.router.navigate(['/login'], {queryParams: {returnUrl: state.url}});
    return false;
  }

}
