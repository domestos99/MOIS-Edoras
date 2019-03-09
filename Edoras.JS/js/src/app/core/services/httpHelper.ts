import {HttpHeaders} from "@angular/common/http";

export class HttpHelper {


  static getHttpOptions() {
    //  let headers = new HttpHeaders();
    //     headers = headers.set('Content-Type', 'application/json; charset=utf-8');
    return {headers: new HttpHeaders().set('Content-Type', 'application/json; charset=utf-8')};
  }
}
