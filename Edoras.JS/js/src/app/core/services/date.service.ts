import {Injectable} from "@angular/core";

@Injectable()
export class DateService {

  // constructor(private datePipe: DatePipe) {
  // }

  formatDt(dt: Date): string {
    if (dt)
      return dt.toISOString();
    else {
      console.log('no dt');
      return '';
    }
    // return this.getCurrentDateInApiFormat(dt);
    // return this.datePipe.transform(dt, 'dd-MM-yyyy');
  }


  getCurrentDateInApiFormat(dt: Date) {

    const date = dt;

    const month = ('0' + (date.getMonth() + 1)).slice(-2);

    const day = ('0' + date.getDate()).slice(-2);

    return [day, month, date.getFullYear()].join('-');

  }

}
