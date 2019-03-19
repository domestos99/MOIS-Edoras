import {Component, EventEmitter, Inject, Input, Output} from '@angular/core';
import {Payment} from "@app/core/api/model/payment";
import {TransactionPartyAccount} from "@app/core/api/model/transactionPartyAccount";
import {FormattingHelper} from "@app/core/helpers/formatting-helper";
import {PaymentValue} from "@app/core/api/model/paymentValue";
import {PaymentCategoryDTO} from "@app/core/model/paymentCategoryDTO";
import {PaymentService} from "@app/modules/secure/payment/payment.service";
import {PaymentCategoryService} from "@app/core/services/paymentCategory.service";
import {NavigationselperService} from "@app/core";
import {MAT_DIALOG_DATA, MatDialog, MatDialogRef} from "@angular/material";
import {Category} from "@app/core/model";
import {CategoryCreateComponent} from "@app/modules/secure/category/category-create/category-create.component";
import {CategoryChangeComponent} from "@app/modules/secure/category/category-change/category-change.component";
import {CategoryChangeModel} from "@app/modules/secure/category/category-change/category-change.model";


@Component({
  selector: 'payment-list-item-detail',
  templateUrl: 'payment-list-item-detail.component.html',
  styleUrls: ['./payment-list-item-detail.component.css']
})
export class PaymentListItemDetailComponent {

  constructor(private paymentCategoryService: PaymentCategoryService,
              public dialog: MatDialog,
              public dialogRef: MatDialogRef<PaymentListItemDetailComponent>,
              @Inject(MAT_DIALOG_DATA) public data: PaymentCategoryDTO) {

  }

  @Output() onRequestReload: EventEmitter<any> = new EventEmitter();

  getAccountFormatted(account: TransactionPartyAccount): string {
    return FormattingHelper.getAccountFormatted(account);
  }

  getMoneyFormatted(paymentValue: PaymentValue): string {
    return FormattingHelper.getMoneyFormattedPay(paymentValue);
  }

  onCategoryChangeClick() {
    this.openChangeCategoryDialog();
  }

  openChangeCategoryDialog(): void {
    const dialogRef = this.dialog.open(CategoryChangeComponent, {
      width: '300px',
      data: {}
    });

    dialogRef.afterClosed().subscribe(result => {

      if (result) {
        console.log(result);
        this.paymentCategoryService.update(this.data, result.newCategory, result.changeType)
          .subscribe(resp => {
            console.log(resp);
            this.onRequestReload.emit();
          });
      }
    });
  }
}
