import {Component, ViewChild} from '@angular/core';
import {CategoryCreateComponent} from "@app/modules/secure/category/category-create/category-create.component";
import {CategoryService} from "@app/modules/secure/category/category.service";
import {MatDialog} from "@angular/material";


@Component({
  selector: 'categories',
  templateUrl: 'category.component.html'
})
export class CategoryComponent {


  constructor(private service: CategoryService, public dialog: MatDialog) {

  }

  @ViewChild('cateListIn') cateListIn;
  @ViewChild('cateListOut') cateListOut;


  addNewCategory() {
    this.openCreateCategory();
  }

  openCreateCategory(): void {
    const dialogRef = this.dialog.open(CategoryCreateComponent, {
      width: '300px',
      data: {name: undefined, icon: undefined, type: undefined}
    });

    dialogRef.afterClosed().subscribe(result => {

      if (result) {
        console.log(result);
        this.service.insert(result.name, result.icon, result.type)
          .subscribe(resp => {
            console.log(resp);
             this.reloadChilds();
          });
      }
    });
  }

  private reloadChilds() {
    this.cateListIn.reload();
    this.cateListOut.reload();
  }
}
