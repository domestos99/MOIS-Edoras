import {Injectable} from '@angular/core'
import {HttpClient} from "@angular/common/http";

@Injectable()
export abstract class ServiceBase {

  private baseUrl = 'http://localhost:4500';

  abstract getApiCall(): String;

  protected http: HttpClient;
  errorHandler = error => alert('ServiceBase error: ' + error);

  getBaseUrl(): string {
    return this.baseUrl;
  }

  protected getServiceUrl(): string {
    return this.getBaseUrl() + "/" + this.getApiCall() + "/";
  }

  constructor(http: HttpClient) {
    this.http = http;
  }


}
