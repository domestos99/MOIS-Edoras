import {Injectable} from "@angular/core";
import {Router} from "@angular/router";


@Injectable()
export class NavigationselperService {

  constructor(private router: Router) {
  }

  openPaymentDetail(id: string) {
    this.router.navigate(['/payments', id]);
  }

  openTransactionDetail(id: string) {
    this.router.navigate(['/transactions', id]);
  }
}
