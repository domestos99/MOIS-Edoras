import {Component, Input, Output, EventEmitter, ViewChild, OnInit} from '@angular/core';

import {CategoryService} from "../category.service";
import {NavigationselperService} from "@app/core";
import {MatDialog} from "@angular/material";
import {CategoryCreateComponent} from "@app/modules/secure/category/category-create/category-create.component";
import {Category} from "@app/core/model";
import {YesNoDialogComponent} from "@app/shared/components/yes-no-dialog/yes-no-dialog.component";


@Component({
  selector: 'category-list',
  templateUrl: 'category-list.component.html'
})
export class CategoryListComponent implements OnInit {

  constructor(private service: CategoryService, public dialog: MatDialog) {

  }

  ngOnInit(): void {
    this.reload();
  }

  @Input()
  set type(val: string) {
    this._type = val;
  }

  _type: string;

  data: Array<Category> = [];

  isLoading: boolean = false;

  public reload() {

    if (!this._type) {
      this.data = [];
      return;
    }

    this.isLoading = true;
    this.service.getAll2(false).subscribe(resp => {
      console.log(resp);

      this.data = resp.filter(c => c.type == this._type);

      this.isLoading = false;
    }, error1 => {
      this.isLoading = false;
    });
  }

  editCategory(row: Category) {
    this.openEditCategory(row);
  }


  openEditCategory(row: Category): void {
    const dialogRef = this.dialog.open(CategoryCreateComponent, {
      width: '300px',
      data: {name: row.name, icon: row.icon, type: row.type}
    });

    dialogRef.afterClosed().subscribe(result => {

      if (result) {
        console.log(result);
        this.service.update(row.id, result.name, result.icon, result.type)
          .subscribe(resp => {
            console.log(resp);
            this.reload();
          });
      }
    });
  }

  onDelete(row: Category) {

    const dialogRef = this.dialog.open(YesNoDialogComponent, {
      width: '300px'
    });

    dialogRef.afterClosed().subscribe(result => {
      console.log(result);
      if (result) {
        this.service.delete(row.id)
          .subscribe(resp => {
            this.reload();
          });
      }
    });

  }


}
