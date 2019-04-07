import {Component} from '@angular/core';

import {TransactionService} from "@app/modules/secure/transaction/transaction.service";
import {TransactionCategoryDTO} from "@app/core/model/transactionCategoryDTO";
import {Filtermodel} from "@app/modules/secure/filter/filtermodel";


@Component({
  selector: 'transaction-list',
  templateUrl: 'transaction-list.component.html',
  styleUrls: ['./transaction-list.component.css']
})
export class TransactionListComponent {

  isLoading: boolean = false;
  filterModel: Filtermodel;

  constructor(private service: TransactionService) {
    this.reload();
  }

  data: Array<TransactionCategoryDTO> = [];

  reload() {
    this.isLoading = true;
    this.service.getAll2(this.filterModel).subscribe(resp => {
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

  onFilterChanged(filterModel: Filtermodel) {
    console.log('onFilterChanged: ', filterModel);
    this.filterModel = filterModel;
    this.reload();
  }
}
