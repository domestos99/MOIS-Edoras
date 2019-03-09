import {Component, EventEmitter, Input, Output} from '@angular/core';
import {TransactionPartyAccount} from "@app/core/api/model/transactionPartyAccount";
import {FormattingHelper} from "@app/core/helpers/formatting-helper";
import {PaymentValue} from "@app/core/api/model/paymentValue";
import {PaymentCategoryDTO} from "@app/core/model/paymentCategoryDTO";


@Component({
  selector: 'payment-list-item',
  templateUrl: 'payment-list-item.component.html',
  styleUrls: ['./payment-list-item.component.css']
})
export class PaymentListItemComponent {


  @Input() data: PaymentCategoryDTO;
  @Output() onOpenDetail: EventEmitter<any> = new EventEmitter();
  @Output() onRequestReload: EventEmitter<any> = new EventEmitter();


  getAccountFormatted(account: TransactionPartyAccount): string {
    return FormattingHelper.getAccountFormatted(account);
  }

  getMoneyFormatted(paymentValue: PaymentValue): string {
    return FormattingHelper.getMoneyFormattedPay(paymentValue);
  }

  openDetail() {
    this.onOpenDetail.emit(null);
  }

  requstReload() {
    this.onRequestReload.emit();
  }
}
