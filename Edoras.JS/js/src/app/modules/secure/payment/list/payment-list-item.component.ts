import {Component, EventEmitter, Input, Output} from '@angular/core';
import {Payment} from "@app/core/api/model/payment";
import {TransactionPartyAccount} from "@app/core/api/model/transactionPartyAccount";
import {FormattingHelper} from "@app/core/helpers/formatting-helper";
import {PaymentValue} from "@app/core/api/model/paymentValue";


@Component({
  selector: 'payment-list-item',
  templateUrl: 'payment-list-item.component.html'
})
export class PaymentListItemComponent {


  @Input() data: Payment;
  @Output() onOpenDetail: EventEmitter<any> = new EventEmitter();


  getAccountFormatted(account: TransactionPartyAccount): string {
    return FormattingHelper.getAccountFormatted(account);
  }

  getMoneyFormatted(paymentValue: PaymentValue) : string {
    return FormattingHelper.getMoneyFormattedPay(paymentValue);
  }

  openDetail() {
    this.onOpenDetail.emit(null);
  }

}
