import {Component, EventEmitter, Inject, Input, Output} from '@angular/core';
import {TransactionPartyAccount} from "@app/core/api/model/transactionPartyAccount";
import {FormattingHelper} from "@app/core/helpers/formatting-helper";
import {PaymentValue} from "@app/core/api/model/paymentValue";
import {TransactionCategoryDTO} from "@app/core/model";
import {TransactionCategoryService} from "@app/core/services/transactionCategory.service";
import {TransactionAdditionalInfoForeignOriginalValue} from "@app/core/api/model/transactionAdditionalInfoForeignOriginalValue";
import {CategoryChangeComponent} from "@app/modules/secure/category/category-change/category-change.component";
import {MAT_DIALOG_DATA, MatDialog, MatDialogRef} from "@angular/material";
import {Logger} from "@app/core/logs";


@Component({
  selector: 'transaction-list-item-detail',
  templateUrl: 'transaction-list-item-detail.component.html',
  styleUrls: ['./transaction-list-item-detail.component.css']
})
export class TransactionListItemDetailComponent {

  constructor(private transactionCategoryService: TransactionCategoryService,
              public dialog: MatDialog,
              public dialogRef: MatDialogRef<TransactionListItemDetailComponent>,
              @Inject(MAT_DIALOG_DATA) public data: TransactionCategoryDTO) {
  }

  @Output() onRequestReload: EventEmitter<any> = new EventEmitter();

  getAccountFormatted(account: TransactionPartyAccount): string {
    return FormattingHelper.getAccountFormatted(account);
  }

  getMoneyFormatted(paymentValue: PaymentValue): string {
    return FormattingHelper.getMoneyFormattedTrans(paymentValue);
  }

  getTransactionAdditionalInfoForeignOriginalValueFormatter(originalValue: TransactionAdditionalInfoForeignOriginalValue): string {
    return FormattingHelper.getTransactionAdditionalInfoForeignOriginalValueFormatter(originalValue);
  }

  onCategoryChangeClick() {
    this.openChangeCategoryDialog();
  }

  openChangeCategoryDialog(): void {
    const dialogRef = this.dialog.open(CategoryChangeComponent, {
      width: '300px',
      data: {direction: this.data.transaction.direction}
    });

    dialogRef.afterClosed().subscribe(result => {

      if (result) {
        Logger.logDebug(result);
        this.transactionCategoryService.update(this.data, result.newCategory, result.changeType)
          .subscribe(resp => {
            Logger.logData(resp);
            this.onRequestReload.emit();
            this.dialogRef.close();
          });
      }
    });
  }


}
