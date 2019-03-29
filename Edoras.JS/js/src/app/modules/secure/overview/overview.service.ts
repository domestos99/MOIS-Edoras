import {Injectable} from "@angular/core";
import {Observable} from "rxjs";
import {ServiceBase} from "@app/core/base/servicebase";
import {PaymentCategoryDTO} from "@app/core/model/paymentCategoryDTO";
import {TransactionOverviewDTO} from "@app/core/model";


@Injectable()
export class OverviewService extends ServiceBase {


  getApiCall(): String {
    return "overview";
  }

  public getTransactionOverview(): Observable<Array<TransactionOverviewDTO>> {
    return this.http.get<Array<TransactionOverviewDTO>>(this.getBaseUrl() + this.getApiCall() + '/transaction');
  }

}
