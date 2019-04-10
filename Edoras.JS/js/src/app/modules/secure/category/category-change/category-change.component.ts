import {Component, Input, Output, EventEmitter, ViewChild, OnInit, Inject} from '@angular/core';
import {MAT_DIALOG_DATA, MatDialogRef, MatSelectChange} from "@angular/material";
import {CategoryService} from "@app/modules/secure/category/category.service";
import {Category} from "@app/core/model";
import {CategoryCreateModel} from "@app/modules/secure/category/category-create/category-create.model";
import {CategoryChangeModel} from "@app/modules/secure/category/category-change/category-change.model";
import {Transaction} from "@app/core/api/model/transaction";


@Component({
  selector: 'category-change',
  templateUrl: 'category-change.component.html',
  styleUrls: ['./category-change.component.css']
})
export class CategoryChangeComponent {

  constructor(
    public dialogRef: MatDialogRef<CategoryChangeComponent>,
    @Inject(MAT_DIALOG_DATA) public data: CategoryChangeModel) {
  }

  submitted = false;

  getCategoryType(): string {
    if (!this.data.direction)
      return null;

    switch (this.data.direction) {
      case Transaction.DirectionEnum.INCOMING:
        return 'INCOME';
      case Transaction.DirectionEnum.OUTGOING:
        return "EXPENSE";
      default:
        return null;
    }

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


  onOkClick() {

    if (this.isDataValid()) {
      this.dialogRef.close(this.data);
    } else {
      this.submitted = true;
    }
  }

  private isDataValid() {
    return (this.data && this.data.newCategory && this.data.changeType);
  }
}
