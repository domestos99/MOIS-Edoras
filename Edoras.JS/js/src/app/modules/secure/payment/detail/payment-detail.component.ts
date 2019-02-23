import {Component, Input, Output, EventEmitter, ViewChild, OnInit, OnDestroy} from '@angular/core';
import {PaymentService} from "../payment.service";
import {ActivatedRoute} from "@angular/router";
import {Payment} from "@app/core/api/model/payment";


@Component({
  selector: 'payments',
  templateUrl: 'payment-detail.component.html'
})
export class PaymentDetailComponent implements OnInit, OnDestroy {

  id: string;
  private sub: any;
  data: Payment;

  constructor(private route: ActivatedRoute, private service: PaymentService) {

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


}
