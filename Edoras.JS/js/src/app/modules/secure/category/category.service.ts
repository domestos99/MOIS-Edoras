import {Injectable} from "@angular/core";
import {Observable} from "rxjs";
import {ServiceBase} from "@app/core/base/servicebase";
import {HttpHelper} from "@app/core/services/httpHelper";
import {Category} from "@app/core/model";
import {HttpClient} from "@angular/common/http";
import {find, map} from "rxjs/operators";
import 'rxjs/add/operator/map'
import 'rxjs/Rx';
import {Cacheable} from "@app/core/services";
import {Logger} from "@app/core/logs";

@Injectable()
export class CategoryService extends ServiceBase {

  getApiCall(): String {
    return "categories";
  }

  loadCategories(): Observable<Array<Category>> {
    return this.http.get<Array<Category>>(this.getBaseUrl() + this.getApiCall());
  }

  list: Cacheable<Array<Category>> = new Cacheable<Array<Category>>();

  constructor(http: HttpClient) {
    super(http);

    this.list.getHandler = () => {
      return this.loadCategories();
    };
    this.list.refresh();
  }

  public getAll2(useCache: boolean): Observable<Array<Category>> {
    if (useCache) {
      return this.list.getData();
    }
    else {
      return this.loadCategories();
    }
  }

  public getAll(): Observable<Array<Category>> {
    return this.getAll2(true);
  }

  public getById(id: string): Observable<Category> {
    // return this.http.get<Category>(this.getBaseUrl() + "category/" + id);
    return this.list.getData()
      .map(cats => cats.find(cat => cat.id == id));
  }


  insert(name: string, icon: string, type: string): Observable<any> {
    let cate: Category;
    cate = new Category(undefined, name, icon, type);

    Logger.logDebug("posting", JSON.stringify(cate));

    let options = HttpHelper.getHttpOptions();
    return this.http.post<any>(this.getBaseUrl() + "category", JSON.stringify(cate), options)
      .pipe((x) => {
          this.list.resetCache();
          return x;
        }
      );
  }

  update(id: string, name: string, icon: string, type: string): Observable<any> {
    let cate: Category;
    cate = new Category(id, name, icon, type);

    Logger.logDebug("putting", JSON.stringify(cate));

    let options = HttpHelper.getHttpOptions();
    return this.http.put<any>(this.getBaseUrl() + "category", JSON.stringify(cate), options)
      .pipe((x) => {
          this.list.resetCache();
          return x;
        }
      );
  }

  delete(id: string): Observable<any> {
    return this.http.delete(this.getBaseUrl() + "category/" + id);
  }
}
