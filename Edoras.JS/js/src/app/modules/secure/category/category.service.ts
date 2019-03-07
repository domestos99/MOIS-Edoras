import {Injectable} from "@angular/core";
import {Observable} from "rxjs";
import {ServiceBase} from "@app/core/base/servicebase";
import {HttpHelper} from "@app/core/services/httpHelper";
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


  insert(name: string, icon: string, type: string): Observable<any> {
    let cate: Category;
    cate = new Category(undefined, name, icon, type);

    console.log("posting");
    console.log(JSON.stringify(cate));

    let options = HttpHelper.getHttpOptions();
    return this.http.post<any>(this.getBaseUrl() + "category", JSON.stringify(cate), options)
  }

  update(id: string, name: string, icon: string, type: string): Observable<any> {
    let cate: Category;
    cate = new Category(id, name, icon, type);

    console.log("puting");
    console.log(JSON.stringify(cate));

    let options = HttpHelper.getHttpOptions();
    return this.http.put<any>(this.getBaseUrl() + "category", JSON.stringify(cate), options)
  }

  delete(id: string): Observable<any> {
    return this.http.delete(this.getBaseUrl() + "category/" + id);
  }
}
