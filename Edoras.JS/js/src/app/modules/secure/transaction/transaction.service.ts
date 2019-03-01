import {Injectable} from "@angular/core";
import {Observable} from "rxjs";
import {Payment} from "@app/core/api/model/payment";
import {ServiceBase} from "@app/core/base/servicebase";
import {Transaction} from "@app/core/api/model/transaction";


@Injectable()
export class TransactionService extends ServiceBase {


  getApiCall(): String {
    return "transactions";
  }

  public getAll(): Observable<Array<Transaction>> {
    return this.http.get<Array<Transaction>>(this.getBaseUrl() + this.getApiCall());
  }

  public getById(id: string): Observable<Transaction> {
    return this.http.get<Transaction>(this.getBaseUrl() + "transaction/" + id);
  }


}
