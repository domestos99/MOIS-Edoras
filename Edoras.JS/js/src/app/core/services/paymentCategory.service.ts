import {Injectable} from "@angular/core";
import {ServiceBase} from "@app/core/base/servicebase";
import {PaymentCategoryDTO, PaymentCategoryUpdateDTO} from "@app/core/model";
import {Observable} from "rxjs";
import {HttpHelper} from "@app/core/services/httpHelper";

@Injectable()
export class PaymentCategoryService extends ServiceBase {

  getApiCall(): String {
    return "paymentcategory";
  }

  update(data: PaymentCategoryDTO, newCategory: string, changeType: string): Observable<any> {
    let dto = new PaymentCategoryUpdateDTO(newCategory, data.payment.id, data.payment.partyAccount, changeType);
    let options = HttpHelper.getHttpOptions();
    return this.http.put<any>(this.getBaseUrl() + "paymentcategory", JSON.stringify(dto), options);
  }

}
