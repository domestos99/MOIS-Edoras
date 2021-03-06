import {Component, EventEmitter, Input, Output} from '@angular/core';
import {TransactionPartyAccount} from "@app/core/api/model/transactionPartyAccount";
import {FormattingHelper} from "@app/core/helpers/formatting-helper";
import {TransactionValue} from "@app/core/api/model/transactionValue";
import {TransactionCategoryDTO} from "@app/core/model/transactionCategoryDTO";
import {MatDialog} from "@angular/material";
import {TransactionListItemDetailComponent} from "@app/modules/secure/transaction/list/transaction-list-item-detail.component";
import {Logger} from "@app/core/logs";


@Component({
  selector: 'transaction-list-item',
  templateUrl: 'transaction-list-item.component.html',
  styleUrls: ['./transaction-list-item.component.css']
})
export class TransactionListItemComponent {

  constructor(public dialog: MatDialog) {
  }

  @Input() data: TransactionCategoryDTO;
  @Output() onRequestReload: EventEmitter<any> = new EventEmitter();

  getAccountFormatted(account: TransactionPartyAccount): string {
    return FormattingHelper.getAccountFormatted(account);
  }

  getMoneyFormatted(paymentValue: TransactionValue): string {
    return FormattingHelper.getMoneyFormattedTrans(paymentValue);
  }

  openDetail() {
    this.openTransactionDetailModal();
  }

  openTransactionDetailModal(): void {
    const dialogRef = this.dialog.open(TransactionListItemDetailComponent, {
      maxWidth: '80vw',
      maxHeight: '80vh',
      width: '80%',
      height: '80%',
      data: this.data,
      panelClass: 'full-screen-modal',
    });

    dialogRef.componentInstance.onRequestReload.subscribe(() =>{
      this.requstReload();
    });

    dialogRef.afterClosed().subscribe(result => {
      if (result) {
        Logger.logDebug(result);
      }
      this.requstReload();
    });
  }

  requstReload() {
    this.onRequestReload.emit();
  }

  isPriceRed() {
    return this.data.transaction.value.amount < 0;
  }

  isPriceGreen() {
    return this.data.transaction.value.amount >= 0;
  }
}
