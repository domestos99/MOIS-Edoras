import {Component, Input, Output, EventEmitter, ViewChild} from '@angular/core';

import {PaymentService} from "../payment.service";
import {NavigationselperService} from "@app/core";
import {Payment} from "@app/core/api/model/payment";


@Component({
  selector: 'payment-list',
  templateUrl: 'payment-list.component.html'
})
export class PaymentListComponent {


  constructor(private service: PaymentService, private navigationselperService: NavigationselperService) {
    this.reload();
  }

  data: Array<Payment> = [];

  reload() {
    this.service.getAll().subscribe(resp => {
      console.log(resp);
      this.data = resp;
    });
  }

  openDetail(row: Payment) {
    this.navigationselperService.openPaymentDetail(row.id);
  }
}
