import {Component, Input, Output, EventEmitter, ViewChild, OnInit, OnDestroy} from '@angular/core';

import {ActivatedRoute} from "@angular/router";
import {Payment} from "@app/core/api/model/payment";
import {TransactionPartyAccount} from "@app/core/api/model/transactionPartyAccount";

import {PaymentValue} from "@app/core/api/model/paymentValue";
import {FormattingHelper} from "@app/core/helpers/formatting-helper";
import {Category} from "@app/core/model";
import {TransactionService} from "@app/modules/secure/transaction/transaction.service";
import {Transaction} from "@app/core/api/model/transaction";
import {TransactionAdditionalInfoForeignOriginalValue} from "@app/core/api/model/transactionAdditionalInfoForeignOriginalValue";
import {TransactionCategoryDTO} from "@app/core/model/transactionCategoryDTO";


@Component({
  selector: 'transaction',
  templateUrl: 'transaction-detail.component.html'
})
export class TransactionDetailComponent implements OnInit, OnDestroy {

  id: string;
  private sub: any;
  data: TransactionCategoryDTO;

  constructor(private route: ActivatedRoute, private service: TransactionService) {
  }


  getAccountFormatted(account: TransactionPartyAccount): string {
    return FormattingHelper.getAccountFormatted(account);
  }

  getMoneyFormatted(paymentValue: PaymentValue): string {
    return FormattingHelper.getMoneyFormattedTrans(paymentValue);
  }

  ngOnInit() {

    this.sub = this.route.params.subscribe(params => {
      this.id = params['id'];
      this.service.getById(this.id)
        .subscribe(value => {
          console.log(value);
          this.data = value
        });
    });

  }

  ngOnDestroy() {
    if (this.sub)
      this.sub.unsubscribe();
  }


  onSelectionChange(newCategoryId: Category) {
    console.log(newCategoryId);
  }

  getTransactionAdditionalInfoForeignOriginalValueFormatter(originalValue: TransactionAdditionalInfoForeignOriginalValue):string {
    return FormattingHelper.getTransactionAdditionalInfoForeignOriginalValueFormatter(originalValue);

  }
}
