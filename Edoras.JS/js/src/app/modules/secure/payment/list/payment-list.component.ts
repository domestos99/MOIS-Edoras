import {Component, Input, Output, EventEmitter, ViewChild} from '@angular/core';

import {PaymentService} from "../payment.service";
import {NavigationselperService} from "@app/core";
import {Payment} from "@app/core/api/model/payment";
import {PaymentCategoryDTO} from "@app/core/model/paymentCategoryDTO";


@Component({
  selector: 'payment-list',
  templateUrl: 'payment-list.component.html'
})
export class PaymentListComponent {


  constructor(private service: PaymentService, private navigationselperService: NavigationselperService) {
    this.reload();
  }

  data: Array<PaymentCategoryDTO> = [];
  panelOpenState = false;

  reload() {
    this.service.getAll().subscribe(resp => {
      console.log(resp);
      this.data = resp;
    });
  }

  openDetail(row: PaymentCategoryDTO) {
    this.navigationselperService.openPaymentDetail(row.payment.id);
  }
}
