import {environment} from "@env/environment";


export class Logger {

  public static logDebug(message?: any, ...optionalParams: any[]): void {
    if (!environment.production) {
      console.log(message, optionalParams);
    }
  }

  public static logError(msg): void {
    console.log(msg);
  }

  static logData(data) {
    if (!environment.production && false) {
      console.log(data);
    }
  }
}
