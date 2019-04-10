import {Component} from '@angular/core';
import {OverviewService} from "@app/modules/secure/overview/overview.service";
import {TransactionOverviewDTO} from "@app/core/model";
import {Logger} from "@app/core/logs";


@Component({
  selector: 'transaction-overview',
  templateUrl: 'transaction-overview.component.html'
})
export class TransactionOverviewComponent {

  isLoading: boolean = false;

  constructor(private service: OverviewService) {
    this.reload();
  }

  data: Array<TransactionOverviewDTO>;

  chartData: Array<ChartData>;
  chartData2: Array<ChartData>;


  reload() {
    this.isLoading = true;
    this.service.getTransactionOverview().subscribe(resp => {
        this.isLoading = false;
        Logger.logData(resp);
        this.data = resp;
        this.udpateChartData();
      },
      error1 => {
        this.isLoading = false;
        Logger.logError(error1);
      });
  }

  private udpateChartData() {

    this.chartData = this.data.map(x => {
      if (x.category && x.category.type == 'INCOME')
        return new ChartData(x.category.name, x.suma);
      else return null;
    });

    this.chartData2 = this.data.map(x => {
      if (x.category && x.category.type == 'EXPENSE')
        return new ChartData(x.category.name, x.suma);
      else return null;
    });

  }
}


export class ChartData {

  constructor(public name: string, public suma: number) {
  }
}
