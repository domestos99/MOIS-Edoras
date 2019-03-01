import {Component, EventEmitter, Input, Output} from '@angular/core';
import {TransactionPartyAccount} from "@app/core/api/model/transactionPartyAccount";
import {FormattingHelper} from "@app/core/helpers/formatting-helper";
import {PaymentValue} from "@app/core/api/model/paymentValue";
import {Transaction} from "@app/core/api/model/transaction";
import {TransactionValue} from "@app/core/api/model/transactionValue";


@Component({
  selector: 'transaction-list-item',
  templateUrl: 'transaction-list-item.component.html'
})
export class TransactionListItemComponent {


  @Input() data: Transaction;
  @Output() onOpenDetail: EventEmitter<any> = new EventEmitter();


  getAccountFormatted(account: TransactionPartyAccount): string {
    return FormattingHelper.getAccountFormatted(account);
  }

  getMoneyFormatted(paymentValue: TransactionValue): string {
    return FormattingHelper.getMoneyFormattedTrans(paymentValue);
  }

  openDetail() {
    this.onOpenDetail.emit(null);
  }

}
