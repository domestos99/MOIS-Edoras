import {Component, Input, Output, EventEmitter, ViewChild} from '@angular/core';

import {NavigationselperService} from "@app/core";
import {Payment} from "@app/core/api/model/payment";
import {Transaction} from "@app/core/api/model/transaction";
import {TransactionService} from "@app/modules/secure/transaction/transaction.service";
import {TransactionCategoryDTO} from "@app/core/model/transactionCategoryDTO";


@Component({
  selector: 'transaction-list',
  templateUrl: 'transaction-list.component.html'
})
export class TransactionListComponent {

  isLoading: boolean = false;

  constructor(private service: TransactionService) {
    this.reload();
  }

  data: Array<TransactionCategoryDTO> = [];
  panelOpenState = false;

  reload() {
    this.isLoading = true;
    this.service.getAll().subscribe(resp => {
        this.isLoading = false;
        console.log(resp);
        this.data = resp;
      },
      error1 => {
        this.isLoading = false;
        console.log(error1);
      });
  }

  requestReload() {
    this.reload();
  }
}
