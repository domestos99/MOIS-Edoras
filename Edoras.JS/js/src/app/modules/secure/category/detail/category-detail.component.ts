import {Component, Input, Output, EventEmitter, ViewChild, OnInit, OnDestroy} from '@angular/core';
import {PaymentService} from "../category.service";
import {ActivatedRoute} from "@angular/router";
import {Category} from "@app/core/api/model/category";


@Component({
  selector: 'categories',
  templateUrl: 'category-detail.component.html'
})
export class CategoryDetailComponent implements OnInit, OnDestroy {

  id: string;
  private sub: any;
  data: Category;

  constructor(private route: ActivatedRoute, private service: CategoryService) {

  }

  ngOnInit() {

    this.sub = this.route.params.subscribe(params => {
      this.id = params['id'];
      this.service.getById(this.id)
        .subscribe(value => {
          console.log(value);
          this.data = value
        });
    });

  }

  ngOnDestroy() {
    if (this.sub)
      this.sub.unsubscribe();
  }


}
