import {Component, Input, Output, EventEmitter, ViewChild} from '@angular/core';

import {PaymentService} from "../payment.service";
import {PaymentCategoryDTO} from "@app/core/model/paymentCategoryDTO";
import {Filtermodel} from "@app/modules/secure/filter/filtermodel";


@Component({
  selector: 'payment-list',
  templateUrl: 'payment-list.component.html',
  styleUrls: ['./payment-list.component.css']
})
export class PaymentListComponent {

  isLoading: boolean = false;

  constructor(private service: PaymentService) {
    this.reload();
  }

  data: Array<PaymentCategoryDTO> = [];
  filterModel: Filtermodel;

  reload() {
    this.isLoading = true;
    this.service.getAll2(this.filterModel).subscribe(resp => {
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

  requestReload() {
    this.reload();
  }

  onFilterChanged(filterModel: Filtermodel) {
    console.log('onFilterChanged: ', filterModel);
    this.filterModel = filterModel;
    this.reload();
  }
}
