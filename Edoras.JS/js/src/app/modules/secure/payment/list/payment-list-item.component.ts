import {Component, EventEmitter, Input, Output} from '@angular/core';
import {TransactionPartyAccount} from "@app/core/api/model/transactionPartyAccount";
import {FormattingHelper} from "@app/core/helpers/formatting-helper";
import {PaymentValue} from "@app/core/api/model/paymentValue";
import {PaymentCategoryDTO} from "@app/core/model/paymentCategoryDTO";
import {PaymentCategoryService} from "@app/core/services/paymentCategory.service";
import {MatDialog} from "@angular/material";
import {CategoryChangeComponent} from "@app/modules/secure/category/category-change/category-change.component";
import {PaymentListItemDetailComponent} from "@app/modules/secure/payment/list/payment-list-item-detail.component";


@Component({
  selector: 'payment-list-item',
  templateUrl: 'payment-list-item.component.html',
  styleUrls: ['./payment-list-item.component.css']
})
export class PaymentListItemComponent {


  constructor(public dialog: MatDialog) {
  }

  @Input() data: PaymentCategoryDTO;
  @Output() onRequestReload: EventEmitter<any> = new EventEmitter();


  getAccountFormatted(account: TransactionPartyAccount): string {
    return FormattingHelper.getAccountFormatted(account);
  }

  getMoneyFormatted(paymentValue: PaymentValue): string {
    return FormattingHelper.getMoneyFormattedPay(paymentValue);
  }

  openDetail() {
    this.openPaymentDetailModal();
  }

  openPaymentDetailModal(): void {
    const dialogRef = this.dialog.open(PaymentListItemDetailComponent, {
      maxWidth: '50vw',
      maxHeight: '60vh',
      width: '50%',
      height: '60%',
      data: this.data,
      panelClass: 'full-screen-modal',
    });

    dialogRef.afterClosed().subscribe(result => {
      if (result) {
        console.log(result);
        this.requstReload();
      }
    });
  }

  requstReload() {
    this.onRequestReload.emit();
  }

  isPriceRed() {
    return this.data.payment.value.amount < 0;
  }

  isPriceGreen() {
    return this.data.payment.value.amount >= 0;
  }
}
