import {Component, EventEmitter, Input, Output} from '@angular/core';
import {Payment} from "@app/core/api/model/payment";
import {TransactionPartyAccount} from "@app/core/api/model/transactionPartyAccount";
import {FormattingHelper} from "@app/core/helpers/formatting-helper";
import {PaymentValue} from "@app/core/api/model/paymentValue";
import {PaymentCategoryDTO} from "@app/core/model/paymentCategoryDTO";
import {PaymentService} from "@app/modules/secure/payment/payment.service";
import {PaymentCategoryService} from "@app/core/services/paymentCategory.service";


@Component({
  selector: 'payment-list-item-detail',
  templateUrl: 'payment-list-item-detail.component.html',
  styleUrls: ['./payment-list-item-detail.component.css']
})
export class PaymentListItemDetailComponent {

  constructor(private paymentCategoryService: PaymentCategoryService) {

  }

  @Input() data: PaymentCategoryDTO;

  getAccountFormatted(account: TransactionPartyAccount): string {
    return FormattingHelper.getAccountFormatted(account);
  }

  getMoneyFormatted(paymentValue: PaymentValue): string {
    return FormattingHelper.getMoneyFormattedPay(paymentValue);
  }


  onSelectionChange(newCategoryId: String) {

    console.log(newCategoryId);
    console.log(this.data.payment);
    this.paymentCategoryService.insertRelation(newCategoryId, this.data.payment)
      .subscribe(r => {
        console.log(r);
      }, e => {
        console.log(e);
      });

  }


}
