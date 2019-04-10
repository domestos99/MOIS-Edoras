import {Component, Input, Output, EventEmitter, ViewChild} from '@angular/core';

import {PaymentService} from "../payment.service";
import {PaymentCategoryDTO} from "@app/core/model/paymentCategoryDTO";
import {Filtermodel} from "@app/modules/secure/filter/filtermodel";
import {Logger} from "@app/core/logs";


@Component({
  selector: 'payment-list',
  templateUrl: 'payment-list.component.html',
  styleUrls: ['./payment-list.component.css']
})
export class PaymentListComponent {

  isLoading: boolean = false;

  constructor(private service: PaymentService) {
    this.reload();
  }

  data: Array<PaymentCategoryDTO> = [];
  filterModel: Filtermodel;

  reload() {
    this.isLoading = true;
    this.service.getAll2(this.filterModel).subscribe(resp => {
        this.isLoading = false;
        Logger.logData(resp);
        this.data = resp;
      },
      error1 => {
        this.isLoading = false;
        Logger.logError(error1);
      });
  }

  requestReload() {
    this.reload();
  }

  onFilterChanged(filterModel: Filtermodel) {
    Logger.logDebug('onFilterChanged: ', filterModel);
    this.filterModel = filterModel;
    this.reload();
  }
}
