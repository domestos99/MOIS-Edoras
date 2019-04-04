import {Component, EventEmitter, Output} from '@angular/core';
import {Filtermodel} from "@app/modules/secure/filter/filtermodel";
import {FormControl} from "@angular/forms";


@Component({
  selector: 'filter',
  templateUrl: 'filter.component.html'
})
export class FilterComponent {

  @Output() filterChanged: EventEmitter<Filtermodel> = new EventEmitter();

  filterObj: Filtermodel = new Filtermodel();

  serializedDateFrom;
  serializedDateTo;

  constructor() {
    this.serializedDateFrom = new FormControl((new Date()).toISOString());
    this.serializedDateTo = new FormControl((new Date()).toISOString());
  }

  selectionChange(event: string) {
    this.filterObj.cateId = event;
    this.onFilterChanged();
  }

  private onFilterChanged() {
    this.filterChanged.emit(this.filterObj);
  }

  onDtFromChangeFrom(event) {
    this.filterObj.dtFrom = event.value;
  }

  onDtFromChangeTo(event) {
    this.filterObj.dtTo = event.value;
  }
}
