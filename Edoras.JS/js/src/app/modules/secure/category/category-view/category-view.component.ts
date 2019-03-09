import {Component, Input, Output, EventEmitter, ViewChild, OnInit} from '@angular/core';
import {CategoryService} from "@app/modules/secure/category/category.service";
import {Category} from "@app/core/model";


@Component({
  selector: 'category-view',
  templateUrl: 'category-view.component.html',
  styleUrls: ['./category-view.component.css']
})
export class CategoryViewComponent {

  isLoading: boolean = false;

  @Input()
  set categoryId(val: string) {
    this._categoryId = val;
    this.loadCategory();
  }

  _categoryId: string;
  category: Category;

  constructor(private categoryService: CategoryService) {
  }

  private loadCategory() {

    if (this._categoryId && this._categoryId != null) {
      this.isLoading = true;
      this.categoryService.getById(this._categoryId).subscribe(resp => {
        this.isLoading = false;
        this.category = resp;
      }, error1 => {
        this.isLoading = false;
        console.log(error1);
      });
    }
  }
}
