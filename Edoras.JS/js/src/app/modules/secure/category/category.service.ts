import {Injectable} from "@angular/core";
import {Observable} from "rxjs";
import {ServiceBase} from "@app/core/base/servicebase";
import {Category} from "@app/core/model";


@Injectable()
export class CategoryService extends ServiceBase {


  getApiCall(): String {
    return "categories";
  }

  public getAll(): Observable<Array<Category>> {
    return this.http.get<Array<Category>>(this.getBaseUrl() + this.getApiCall());
  }

  public getById(id: string): Observable<Category> {
    return this.http.get<Category>(this.getBaseUrl() + "category/" + id);
  }


}
