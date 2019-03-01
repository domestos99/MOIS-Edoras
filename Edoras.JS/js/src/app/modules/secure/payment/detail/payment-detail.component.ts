import {Component, Input, Output, EventEmitter, ViewChild, OnInit, OnDestroy} from '@angular/core';
import {PaymentService} from "../payment.service";
import {ActivatedRoute} from "@angular/router";
import {Payment} from "@app/core/api/model/payment";
import {TransactionPartyAccount} from "@app/core/api/model/transactionPartyAccount";

import {PaymentValue} from "@app/core/api/model/paymentValue";
import {FormattingHelper} from "@app/core/helpers/formatting-helper";
import {Category} from "@app/core/model";
import {PaymentCategoryDTO} from "@app/core/model/paymentCategoryDTO";
import {PaymentCategoryService} from "@app/core/services/paymentCategory.service";


@Component({
  selector: 'payment-detail',
  templateUrl: 'payment-detail.component.html'
})
export class PaymentDetailComponent implements OnInit, OnDestroy {

  id: string;
  private sub: any;
  data: PaymentCategoryDTO;

  constructor(private route: ActivatedRoute, private service: PaymentService, private paymentService: PaymentCategoryService) {
  }

  getAccountFormatted(account: TransactionPartyAccount): string {
    return FormattingHelper.getAccountFormatted(account);
  }

  getMoneyFormatted(paymentValue: PaymentValue): string {
    return FormattingHelper.getMoneyFormattedPay(paymentValue);
  }

  ngOnInit() {
    this.sub = this.route.params.subscribe(params => {
      this.id = params['id'];
      this.service.getById(this.id)
        .subscribe(value => {
          console.log(value);
          this.data = value
        });
    });
  }

  ngOnDestroy() {
    if (this.sub)
      this.sub.unsubscribe();
  }

  onSelectionChange(newCategoryId: String) {

    console.log(newCategoryId);
    console.log(this.data.payment);
    this.paymentService.insertRelation(newCategoryId, this.data.payment)
      .subscribe(r => {
        console.log(r);
      }, e => {
        console.log(e);
      });

  }
}
