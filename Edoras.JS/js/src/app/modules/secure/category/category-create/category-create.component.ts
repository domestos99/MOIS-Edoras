import {Component, Inject, OnInit} from '@angular/core';
import {MAT_DIALOG_DATA, MatDialog, MatDialogRef} from "@angular/material";
import {CategoryCreateModel} from "@app/modules/secure/category/category-create/category-create.model";


@Component({
  selector: 'category-create',
  templateUrl: 'category-create.component.html'
})
export class CategoryCreateComponent {

  constructor(
    public dialogRef: MatDialogRef<CategoryCreateComponent>,
    @Inject(MAT_DIALOG_DATA) public data: CategoryCreateModel) {


  }

  iconsList = [
    {name: 'shopping_cart'},
    {name: 'home'},
    {name: 'restaurant'},
    {name: 'smoking_rooms'},
    {name: 'mood'},
    {name: 'phone'},
    {name: 'desktop_windows'},
    {name: 'local_gas_station'},
  ];

  types = [
    {name: 'INCOME',},
    {name: 'EXPENSE',}
  ];

  onNoClick(): void {
    this.dialogRef.close();
  }


}
