import {Injectable} from "@angular/core";
import {ServiceBase} from "@app/core/base/servicebase";
import {Observable} from "rxjs";
import {HttpHelper} from "@app/core/services/httpHelper";
import {Transaction} from "@app/core/api/model/transaction";
import {TransactionCategoryInsertDTO} from "@app/core/model";


@Injectable()
export class TransactionCategoryService extends ServiceBase {


  getApiCall(): String {
    return "transactioncategory";
  }


  insertRelation(newCategoryId: string, transaction: Transaction): Observable<any> {

    let dto = new TransactionCategoryInsertDTO(newCategoryId, transaction.id, undefined);

    console.log("posting");
    console.log(JSON.stringify(dto));

    let options = HttpHelper.getHttpOptions();
    return this.http.post<any>(this.getBaseUrl() + "transactioncategory", JSON.stringify(dto), options);

  }
}
