import {Injectable} from "@angular/core";
import {Observable} from "rxjs";
import {Payment} from "@app/core/api/model/payment";
import {ServiceBase} from "@app/core/base/servicebase";
import {PaymentCategoryDTO} from "@app/core/model/paymentCategoryDTO";


@Injectable()
export class PaymentService extends ServiceBase {


  getApiCall(): String {
    return "payments";
  }

  public getAll(): Observable<Array<PaymentCategoryDTO>> {
    return this.http.get<Array<PaymentCategoryDTO>>(this.getBaseUrl() + this.getApiCall());
  }

  public getById(id: string): Observable<PaymentCategoryDTO> {
    return this.http.get<PaymentCategoryDTO>(this.getBaseUrl() + "payment/" + id);
  }


}
