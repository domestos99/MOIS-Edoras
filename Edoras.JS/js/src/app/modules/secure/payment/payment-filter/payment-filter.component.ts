import {Component, EventEmitter, Output} from '@angular/core';
import {Category} from "@app/core/model";
import {PaymentFilterModel} from "@app/modules/secure/payment/payment-filter/paymentFilter.model";


@Component({
  selector: 'payment-filter',
  templateUrl: 'payment-filter.component.html'
})
export class PaymentFilterComponent {

  @Output() onFilterChanged: EventEmitter<PaymentFilterModel> = new EventEmitter();

  categoryId: string;

  onCategoryChange(category: string) {
    this.categoryId = category;
    this.emitChange();
  }


  emitChange() {
    let model = new PaymentFilterModel(this.categoryId);
    this.onFilterChanged.emit(model);
  }

}
