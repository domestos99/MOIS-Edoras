import {Injectable} from "@angular/core";
import {Observable} from "rxjs";
import {Payment} from "@app/core/api/model/payment";
import {ServiceBase} from "@app/core/base/servicebase";
import {Transaction} from "@app/core/api/model/transaction";
import {TransactionCategoryDTO} from "@app/core/model/transactionCategoryDTO";
import {HttpClient, HttpParams} from "@angular/common/http";
import {DateService} from "@app/core/services";
import {Filtermodel} from "@app/modules/secure/filter/filtermodel";


@Injectable()
export class TransactionService extends ServiceBase {

  constructor(http: HttpClient, private dateHelper: DateService) {
    super(http);
  }

  getApiCall(): String {
    return "transactions";
  }

  public getAll(): Observable<Array<TransactionCategoryDTO>> {
    return this.http.get<Array<TransactionCategoryDTO>>(this.getBaseUrl() + this.getApiCall());
  }


  public getAll2(filterModel: Filtermodel): Observable<Array<TransactionCategoryDTO>> {

    let _params;
    if (filterModel) {
      _params = new HttpParams()
        .set("cateId", filterModel.cateId ? filterModel.cateId : '')
        .set("dtFrom", this.dateHelper.formatDt(filterModel.dtFrom))
        .set("dtTo", this.dateHelper.formatDt(filterModel.dtTo));
    } else {
      _params = new HttpParams();
    }

    return this.http.get<Array<TransactionCategoryDTO>>(this.getBaseUrl() + this.getApiCall(),
      {
        params: _params
      });
  }

  public getById(id: string): Observable<TransactionCategoryDTO> {
    return this.http.get<TransactionCategoryDTO>(this.getBaseUrl() + "transaction/" + id);
  }


}
