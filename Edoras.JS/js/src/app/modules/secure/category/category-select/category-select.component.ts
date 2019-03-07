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

  @Output() selectionChange: EventEmitter<Category> = new EventEmitter();
  @Input() selectedValue: string;

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
    this.selectionChange.emit(change.value);
  }

  getCategoryIcon(id: string): Category {
    if (!this.categories)
      return undefined;

    let cat = this.categories.find(x => x.id == id);
    if (cat)
      return cat.icon;
    return undefined;
  }

  getCategoryName(id: string) {
    if (!this.categories)
      return undefined;

    let cat = this.categories.find(x => x.id == id);
    if (cat)
      return cat.name;
    return undefined;
  }
}
