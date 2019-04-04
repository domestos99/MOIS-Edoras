import {
  Component,
  Input,
  Output,
  EventEmitter,
  ViewChild,
  OnInit,
  HostListener
} from '@angular/core';
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
  @Input() editable: boolean;

  @Output() onClick: EventEmitter<any> = new EventEmitter();

  @HostListener("click") onCompClick() {
    console.log('on category-view click');
    this.onClick.emit(null);
  }


  isEditable(): boolean {
    if (this.editable)
      return this.editable;
    return false;

  }
}
