import {Component, EventEmitter, Output} from '@angular/core';
import {Filtermodel} from "@app/modules/secure/filter/filtermodel";
import {FormControl} from "@angular/forms";


@Component({
  selector: 'filter',
  templateUrl: 'filter.component.html',
  styleUrls: ['./filter.component.css']
})
export class FilterComponent {

  @Output() filterChanged: EventEmitter<Filtermodel> = new EventEmitter();

  filterObj: Filtermodel = new Filtermodel();

  serializedDateFrom;
  serializedDateTo;

  constructor() {

    let dtFrom = new Date();
    dtFrom.setDate(dtFrom.getDate() - 30);
    let dtTo = new Date();

    this.serializedDateFrom = new FormControl((dtFrom).toISOString());
    this.serializedDateTo = new FormControl((dtTo).toISOString());

    this.filterObj.dtFrom = dtFrom;
    this.filterObj.dtTo = dtTo;
  }

  selectionChange(event: string) {
    this.filterObj.cateId = event;
  }

  onDtFromChangeFrom(event) {
    this.filterObj.dtFrom = event.value;
  }

  onDtFromChangeTo(event) {
    this.filterObj.dtTo = event.value;
  }

  private onFilterChanged() {
    this.filterChanged.emit(this.filterObj);
  }

  onFilterSubmit() {
    this.onFilterChanged();
  }
}
