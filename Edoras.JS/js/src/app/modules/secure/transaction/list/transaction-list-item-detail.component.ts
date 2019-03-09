import {Component, EventEmitter, Input, Output} from '@angular/core';
import {Payment} from "@app/core/api/model/payment";
import {TransactionPartyAccount} from "@app/core/api/model/transactionPartyAccount";
import {FormattingHelper} from "@app/core/helpers/formatting-helper";
import {PaymentValue} from "@app/core/api/model/paymentValue";
import {PaymentCategoryDTO} from "@app/core/model/paymentCategoryDTO";
import {TransactionCategoryDTO} from "@app/core/model";
import {TransactionCategoryService} from "@app/core/services/transactionCategory.service";
import {TransactionAdditionalInfoForeignOriginalValue} from "@app/core/api/model/transactionAdditionalInfoForeignOriginalValue";


@Component({
  selector: 'transaction-list-item-detail',
  templateUrl: 'transaction-list-item-detail.component.html',
  styleUrls: ['./transaction-list-item-detail.component.css']
})
export class TransactionListItemDetailComponent {

  constructor(private transactionCategoryService: TransactionCategoryService) {

  }

  @Input() data: TransactionCategoryDTO;

  getAccountFormatted(account: TransactionPartyAccount): string {
    return FormattingHelper.getAccountFormatted(account);
  }

  getMoneyFormatted(paymentValue: PaymentValue): string {
    return FormattingHelper.getMoneyFormattedTrans(paymentValue);
  }

  getTransactionAdditionalInfoForeignOriginalValueFormatter(originalValue: TransactionAdditionalInfoForeignOriginalValue): string {
    return FormattingHelper.getTransactionAdditionalInfoForeignOriginalValueFormatter(originalValue);
  }

  onSelectionChange(newCategoryId: string) {

    console.log(newCategoryId);
    console.log(this.data.transaction);
    this.transactionCategoryService.insertRelation(newCategoryId, this.data.transaction)
      .subscribe(r => {
        console.log(r);
      }, e => {
        console.log(e);
      });

  }


}
