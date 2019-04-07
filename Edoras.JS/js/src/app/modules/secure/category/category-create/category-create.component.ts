import {Component, Inject, OnInit} from '@angular/core';
import {MAT_DIALOG_DATA, MatDialog, MatDialogRef} from "@angular/material";
import {CategoryCreateModel} from "@app/modules/secure/category/category-create/category-create.model";
import {FormBuilder, FormGroup, Validators} from "@angular/forms";


@Component({
  selector: 'category-create',
  templateUrl: 'category-create.component.html',
  styleUrls: ['./category-create.component.css']
})
export class CategoryCreateComponent implements OnInit {

  constructor(
    private formBuilder: FormBuilder,
    public dialogRef: MatDialogRef<CategoryCreateComponent>,
    @Inject(MAT_DIALOG_DATA) public data: CategoryCreateModel) {
  }

  inputForm: FormGroup;
  submitted = false;

  ngOnInit() {
    this.inputForm = this.formBuilder.group({
      catename: [this.data.name, Validators.required],
      cateicon: [this.data.icon, Validators.required],
      catetype: [this.data.type, Validators.required],
    });

  }

  // convenience getter for easy access to form fields
  get f() {
    return this.inputForm.controls;
  }

  onOkClick() {

    if (this.isDataValid()) {
      this.dialogRef.close(this.data);
    } else {
      this.submitted = true;
      // stop here if form is invalid
      if (this.inputForm.invalid) {
        return;
      }

    }
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


  private isDataValid() {
    return (this.data && this.data.name && this.data.type && this.data.icon);
  }
}
