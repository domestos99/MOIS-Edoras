import {Component, Inject, OnInit} from '@angular/core';
import {MAT_DIALOG_DATA, MatDialog, MatDialogRef} from "@angular/material";
import {CategoryCreateModel} from "@app/modules/secure/category/category-create/category-create.model";


@Component({
  selector: 'yes-no-dialog',
  templateUrl: 'yes-no-dialog.component.html'
})
export class YesNoDialogComponent {

  constructor(
    public dialogRef: MatDialogRef<YesNoDialogComponent>) {


  }

  onNoClick(): void {
    this.dialogRef.close();
  }


}
