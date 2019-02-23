import {Injectable} from '@angular/core'
import {HttpClient} from "@angular/common/http";
import {AppConfig} from "@app/core/app.config";

@Injectable()
export abstract class ServiceBase {

  abstract getApiCall(): String;

  protected http: HttpClient;
  errorHandler = error => alert('ServiceBase error: ' + error);

  getBaseUrl(): string {
    return AppConfig.getBaseAddress();
  }

  protected getServiceUrl(): string {
    return this.getBaseUrl() + "/" + this.getApiCall() + "/";
  }

  constructor(http: HttpClient) {
    this.http = http;
  }


}
