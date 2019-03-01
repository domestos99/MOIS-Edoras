import {Component, Input, Output, EventEmitter, ViewChild} from '@angular/core';

import {CategoryService, PaymentService} from "../category.service";
import {NavigationselperService} from "@app/core";
import {Category} from "@app/core/api/model/category";


@Component({
  selector: 'category-list',
  templateUrl: 'category-list.component.html'
})
export class CategoryListComponent {


  constructor(private service: CategoryService, private navigationselperService: NavigationselperService) {
    this.reload();
  }

  data: Array<Category> = [];

  reload() {
    this.service.getAll().subscribe(resp => {
      console.log(resp);
      this.data = resp;
    });
  }

  openDetail(row: Category) {
    this.navigationselperService.openCategoryDetail(row.id.toString());
  }
}
