import {Injectable} from "@angular/core";
import {ServiceBase} from "@app/core/base/servicebase";
import {Observable} from "rxjs";
import {HttpHelper} from "@app/core/services/httpHelper";
import {Transaction} from "@app/core/api/model/transaction";
import {
  PaymentCategoryDTO,
  PaymentCategoryUpdateDTO, TransactionCategoryDTO,
  TransactionCategoryUpdateDTO
} from "@app/core/model";


@Injectable()
export class TransactionCategoryService extends ServiceBase {


  getApiCall(): String {
    return "transactioncategory";
  }

  update(transactionDto: TransactionCategoryDTO, newCategory: string, changeType: string): Observable<any> {
    let dto = new TransactionCategoryUpdateDTO(newCategory, transactionDto.transaction.id, transactionDto.transaction.partyAccount, changeType);
    let options = HttpHelper.getHttpOptions();
    return this.http.put<any>(this.getBaseUrl() + "transactioncategory", JSON.stringify(dto), options);
  }
}
