import {Injectable} from "@angular/core";
import {ServiceBase} from "@app/core/base/servicebase";
import {PaymentCategoryInsertDTO} from "@app/core/model";
import {Payment} from "@app/core/api/model/payment";
import {Observable} from "rxjs";
import {HttpHeaders} from "@angular/common/http";

@Injectable()
export class PaymentCategoryService extends ServiceBase {


  getApiCall(): String {
    return "paymentcategory";
  }


  insertRelation(newCategoryId: String, payment: Payment): Observable<any> {

    let dto = new PaymentCategoryInsertDTO(newCategoryId, payment.id, undefined);
    // dto.categoryId = newCategoryId
    // dto.paymentId = payment.id;
    console.log("posting");
    console.log(JSON.stringify(dto));

    let headers = new HttpHeaders();
    headers = headers.set('Content-Type', 'application/json; charset=utf-8');

    return this.http.post<any>(this.getBaseUrl() + "paymentcategory", JSON.stringify(dto),
      {headers: new HttpHeaders().set('Content-Type', 'application/json; charset=utf-8')});
  }
}
