import {Component, EventEmitter, Inject, Input, Output} from '@angular/core';
import {TransactionPartyAccount} from "@app/core/api/model/transactionPartyAccount";
import {FormattingHelper} from "@app/core/helpers/formatting-helper";
import {PaymentValue} from "@app/core/api/model/paymentValue";
import {PaymentCategoryDTO} from "@app/core/model/paymentCategoryDTO";
import {PaymentCategoryService} from "@app/core/services/paymentCategory.service";
import {MAT_DIALOG_DATA, MatDialog, MatDialogRef} from "@angular/material";
import {CategoryChangeComponent} from "@app/modules/secure/category/category-change/category-change.component";
import {Logger} from "@app/core/logs";


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
        Logger.logDebug(result);
        this.paymentCategoryService.update(this.data, result.newCategory, result.changeType)
          .subscribe(resp => {
            Logger.logData(resp);
            this.onRequestReload.emit();
            this.dialogRef.close();
          });
      }
    });
  }
}
