import {Injectable} from "@angular/core";
import {Observable} from "rxjs";
import {Payment} from "@app/core/api/model/payment";
import {ServiceBase} from "@app/core/base/servicebase";


@Injectable()
export class PaymentService extends ServiceBase {


  getApiCall(): String {
    return "payments";
  }

  public getAll(): Observable<Array<Payment>> {
    return this.http.get<Array<Payment>>(this.getBaseUrl() + this.getApiCall());
  }

  public getById(id: string): Observable<Payment> {
    return this.http.get<Payment>(this.getBaseUrl() + "payment/" + id);
  }


}
