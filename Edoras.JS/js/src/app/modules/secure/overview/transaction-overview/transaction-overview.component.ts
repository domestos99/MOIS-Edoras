import {Component} from '@angular/core';
import {OverviewService} from "@app/modules/secure/overview/overview.service";
import {TransactionOverviewDTO} from "@app/core/model";


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

  reload() {
    this.isLoading = true;
    this.service.getTransactionOverview().subscribe(resp => {
        this.isLoading = false;
        console.log(resp);
        this.data = resp;
      },
      error1 => {
        this.isLoading = false;
        console.log(error1);
      });
  }


}
