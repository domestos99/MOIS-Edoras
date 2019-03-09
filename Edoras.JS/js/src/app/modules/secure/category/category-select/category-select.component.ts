import {Component, Input, Output, EventEmitter, ViewChild, OnInit} from '@angular/core';
import {MatSelectChange} from "@angular/material";
import {CategoryService} from "@app/modules/secure/category/category.service";
import {Category} from "@app/core/model";


@Component({
  selector: 'category-select',
  templateUrl: 'category-select.component.html'
})
export class CategorySelectComponent implements OnInit {

  categories: Array<Category>;

  @Output() selectionChange: EventEmitter<string> = new EventEmitter();
  @Input() selectedValue: string;
  @Input() disabled: boolean;

  constructor(private service: CategoryService) {
  }

  ngOnInit(): void {
    this.reload();
  }

  reload() {
    this.service.getAll().subscribe(resp => {
      console.log(resp);
      this.categories = resp;
    });
  }

  onselectionChange(change: MatSelectChange) {
    console.log('change');
    console.log(change.value);
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
