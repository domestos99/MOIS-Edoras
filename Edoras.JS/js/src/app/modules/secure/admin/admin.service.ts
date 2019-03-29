import {Injectable} from "@angular/core";
import {ServiceBase} from "@app/core/base/servicebase";
import {Observable} from "rxjs";
import {PaymentCategoryDTO} from "@app/core/model";


@Injectable()
export class AdminService extends ServiceBase {


  getApiCall(): String {
    return null;
  }

  realodDataFromApi(): Observable<boolean> {
    return this.http.get<boolean>(this.getBaseUrl() + 'synchronizenow');
  }
}
