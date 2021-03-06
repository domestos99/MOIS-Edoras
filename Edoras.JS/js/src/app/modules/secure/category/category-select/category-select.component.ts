import {Component, Input, Output, EventEmitter, ViewChild, OnInit} from '@angular/core';
import {MatSelectChange} from "@angular/material";
import {CategoryService} from "@app/modules/secure/category/category.service";
import {Category} from "@app/core/model";
import {Logger} from "@app/core/logs";


@Component({
  selector: 'category-select',
  templateUrl: 'category-select.component.html'
})
export class CategorySelectComponent implements OnInit {

  categories: Array<Category>;

  @Output() selectionChange: EventEmitter<string> = new EventEmitter();
  @Input() selectedValue: string;
  @Input() disabled: boolean;

  @Input()
  set type(val: string) {
    this._type = val;
  }

  _type: string;

  constructor(private service: CategoryService) {
  }

  ngOnInit(): void {
    this.reload();
  }

  reload() {
    this.service.getAll().subscribe(resp => {
      Logger.logData(resp);
      if (!this._type) {
        this.categories = resp;
      }
      else {
        this.categories = resp.filter(c => c.type == this._type);
      }
    });
  }

  onselectionChange(change: MatSelectChange) {
    Logger.logDebug('change', change.value);
    this.selectionChange.emit(change.value);
  }

  getCategoryIcon(id: string): string {
    if (!this.categories)
      return undefined;

    let cat = this.categories.find(x => x.id == id);
    if (cat)
      return cat.icon;
    return undefined;
  }

  getCategoryName(id: string): string {
    if (!this.categories)
      return undefined;

    let cat = this.categories.find(x => x.id == id);
    if (cat)
      return cat.name;
    return undefined;
  }
}
