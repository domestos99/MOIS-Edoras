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
import {Logger} from "@app/core/logs";


@Component({
  selector: 'category-view',
  templateUrl: 'category-view.component.html',
  styleUrls: ['./category-view.component.css']
})
export class CategoryViewComponent {

  isLoading: boolean = false;

  acategory : Category;

  @Input()
  set category(value : Category) {
    this.acategory = value;
  }

  @Input() editable: boolean;

  @Output() onClick: EventEmitter<any> = new EventEmitter();

  @HostListener("click") onCompClick() {
    Logger.logDebug('on category-view click');
    this.onClick.emit(null);
  }


  isEditable(): boolean {
    if (this.editable)
      return this.editable;
    return false;

  }
}
