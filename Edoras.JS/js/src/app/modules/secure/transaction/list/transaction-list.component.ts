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


  constructor(private service: TransactionService, private navigationselperService: NavigationselperService) {
    this.reload();
  }

  data: Array<TransactionCategoryDTO> = [];
  panelOpenState = false;

  reload() {
    this.service.getAll().subscribe(resp => {
      console.log(resp);
      this.data = resp;
    });
  }

  openDetail(row: TransactionCategoryDTO) {
    this.navigationselperService.openTransactionDetail(row.transaction.id);
  }
}
