import {Component, Input, Output, EventEmitter, ViewChild} from '@angular/core';

import {PaymentService} from "../payment.service";
import {NavigationselperService} from "@app/core";
import {Payment} from "@app/core/api/model/payment";
import {PaymentCategoryDTO} from "@app/core/model/paymentCategoryDTO";
import {PaymentFilterModel} from "@app/modules/secure/payment/payment-filter/paymentFilter.model";


@Component({
  selector: 'payment-list',
  templateUrl: 'payment-list.component.html'
})
export class PaymentListComponent {

  isLoading: boolean = false;

  constructor(private service: PaymentService) {
    this.reload();
  }

  data: Array<PaymentCategoryDTO> = [];
  panelOpenState = false;
  filterModel: PaymentFilterModel;

  reload() {
    this.isLoading = true;
    this.service.getAll().subscribe(resp => {
        this.isLoading = false;
        console.log(resp);
        this.data = resp;
      },
      error1 => {
        this.isLoading = false;
        console.log(error1);
      });
    // this.isLoading = true;
    // this.service.getAll().subscribe(resp => {
    //
    //   this.isLoading = false;
    //
    //   console.log(resp);
    //
    //   if (!this.filterModel) {
    //     this.data = resp;
    //   }
    //   else {
    //     this.data = resp.filter(it => {
    //       if (this.filterModel.categoryId) {
    //         return it.categoryId == this.filterModel.categoryId;
    //       }
    //       return true;
    //     });
    //   }
    // }, error1 => {
    //   this.isLoading = false;
    //   console.log(error1);
    // });
  }

  filterChanged(filterModel: PaymentFilterModel) {
    this.filterModel = filterModel;
    console.log('filter changed');
    this.reload();
  }

  requestReload() {
    this.reload();
  }

  onFilterChanged(event) {
    console.log(event);
  }
}
