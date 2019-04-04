import {Injectable} from "@angular/core";
import {Observable} from "rxjs";
import {ServiceBase} from "@app/core/base/servicebase";
import {PaymentCategoryDTO} from "@app/core/model/paymentCategoryDTO";
import {Filtermodel} from "@app/modules/secure/filter/filtermodel";
import {HttpParams} from "@angular/common/http";
import {HttpClient} from "@angular/common/http";
import {DateService} from "@app/core/services";


@Injectable()
export class PaymentService extends ServiceBase {


  constructor(http: HttpClient, private dateHelper: DateService) {
    super(http);
  }

  getApiCall(): String {
    return "payments";
  }

  public getAll(): Observable<Array<PaymentCategoryDTO>> {
    return this.http.get<Array<PaymentCategoryDTO>>(this.getBaseUrl() + this.getApiCall());
  }

  public getAll2(filterModel: Filtermodel): Observable<Array<PaymentCategoryDTO>> {

    let _params;
    if (filterModel) {
      _params = new HttpParams()
        .set("cateId", filterModel.cateId ? filterModel.cateId : '')
        .set("dtFrom", this.dateHelper.formatDt(filterModel.dtFrom))
        .set("dtTo", this.dateHelper.formatDt(filterModel.dtTo));
    } else {
      _params = new HttpParams();
    }

    return this.http.get<Array<PaymentCategoryDTO>>(this.getBaseUrl() + this.getApiCall(),
      {
        params: _params
      });
  }

  public getById(id: string): Observable<PaymentCategoryDTO> {
    return this.http.get<PaymentCategoryDTO>(this.getBaseUrl() + "payment/" + id);
  }


}
