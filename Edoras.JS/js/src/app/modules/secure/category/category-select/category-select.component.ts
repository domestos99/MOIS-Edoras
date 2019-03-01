import {Component, Input, Output, EventEmitter, ViewChild, OnInit} from '@angular/core';
import {Category} from "@app/core/model";
import {MatSelectChange} from "@angular/material";
import {CategoryService} from "@app/modules/secure/category/category.service";


@Component({
  selector: 'category-select',
  templateUrl: 'category-select.component.html'
})
export class CategorySelectComponent implements OnInit {

  categories: Array<Category>;

  @Output() selectionChange: EventEmitter<Category> = new EventEmitter();
  @Input() selectedValue : String;

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


}
