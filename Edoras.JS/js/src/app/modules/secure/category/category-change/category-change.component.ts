import {Component, Input, Output, EventEmitter, ViewChild, OnInit, Inject} from '@angular/core';
import {MAT_DIALOG_DATA, MatDialogRef, MatSelectChange} from "@angular/material";
import {CategoryService} from "@app/modules/secure/category/category.service";
import {Category} from "@app/core/model";
import {CategoryCreateModel} from "@app/modules/secure/category/category-create/category-create.model";
import {CategoryChangeModel} from "@app/modules/secure/category/category-change/category-change.model";


@Component({
  selector: 'category-change',
  templateUrl: 'category-change.component.html'
})
export class CategoryChangeComponent {

  constructor(
    public dialogRef: MatDialogRef<CategoryChangeComponent>,
    @Inject(MAT_DIALOG_DATA) public data: CategoryChangeModel) {
  }

  changeTypes = [
    {
      id: "ALL",
      name: "Change for all"
    },
    {
      id: "ONE",
      name: "Change only for this"
    }
  ];

  onSelectionChanged(newCategoryId: string) {
    this.data.newCategory = newCategoryId;
  }


  onNoClick(): void {
    this.dialogRef.close();
  }


}
