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

  @Input() category: Category;
}
