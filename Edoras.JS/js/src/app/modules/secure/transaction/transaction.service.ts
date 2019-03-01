import {Injectable} from "@angular/core";
import {Observable} from "rxjs";
import {Payment} from "@app/core/api/model/payment";
import {ServiceBase} from "@app/core/base/servicebase";
import {Transaction} from "@app/core/api/model/transaction";
import {TransactionCategoryDTO} from "@app/core/model/transactionCategoryDTO";


@Injectable()
export class TransactionService extends ServiceBase {


  getApiCall(): String {
    return "transactions";
  }

  public getAll(): Observable<Array<TransactionCategoryDTO>> {
    return this.http.get<Array<TransactionCategoryDTO>>(this.getBaseUrl() + this.getApiCall());
  }

  public getById(id: string): Observable<TransactionCategoryDTO> {
    return this.http.get<TransactionCategoryDTO>(this.getBaseUrl() + "transaction/" + id);
  }


}
