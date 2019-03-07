import {NgModule} from '@angular/core';
import {CommonModule} from '@angular/common';
import {FormsModule, ReactiveFormsModule} from '@angular/forms';
import {RouterModule} from '@angular/router';

import {MaterialModule} from './material.module';

import {NgbModule} from '@ng-bootstrap/ng-bootstrap';
import {FontAwesomeModule} from '@fortawesome/angular-fontawesome';
// import { NgxMasonryModule } from 'ngx-ma/sonry';
import {library} from '@fortawesome/fontawesome-svg-core';

import {
  faAsterisk,
  faBars,
  faUserCircle,
  faPowerOff,
  faCog,
  faPlayCircle,
  faRocket,
  faPlus,
  faEdit,
  faTrash,
  faTimes,
  faCaretUp,
  faCaretDown,
  faExclamationTriangle,
  faFilter,
  faTasks,
  faCheck,
  faSquare,
  faLanguage,
  faPaintBrush,
  faLightbulb,
  faWindowMaximize,
  faStream,
  faBook
} from '@fortawesome/free-solid-svg-icons';

library.add(
  faAsterisk,
  faBars,
  faUserCircle,
  faPowerOff,
  faCog,
  faRocket,
  faPlayCircle,
  faPlus,
  faEdit,
  faTrash,
  faTimes,
  faCaretUp,
  faCaretDown,
  faExclamationTriangle,
  faFilter,
  faTasks,
  faCheck,
  faSquare,
  faLanguage,
  faPaintBrush,
  faLightbulb,
  faWindowMaximize,
  faStream,
  faBook
);


import {DetailButtonComponent} from './components/detailbutton/detail-button.component';
import {DeleteButtonComponent} from './components/detelebutton/delete-button.component';
import {AddButtonComponent} from "@app/shared/components/add-button/add-button.component";
import {AlertComponent} from "@app/shared/components/alert-component/alert.component";
import {EditButtonComponent} from "@app/shared/components/edit-button/edit-button.component";
import {YesNoDialogComponent} from "@app/shared/components/yes-no-dialog/yes-no-dialog.component";
import {CategoryCreateComponent} from "@app/modules/secure/category/category-create/category-create.component";

@NgModule({
  imports: [
    CommonModule,
    FormsModule,
    ReactiveFormsModule,
    RouterModule,
    MaterialModule,

    NgbModule.forRoot(),
    FontAwesomeModule
  ],
  declarations: [

    DetailButtonComponent,
    DeleteButtonComponent,
    AlertComponent,
    EditButtonComponent,
    YesNoDialogComponent,

    AddButtonComponent
  ],
  entryComponents:
    [
      YesNoDialogComponent

    ],
  exports: [
    CommonModule,
    FormsModule,
    ReactiveFormsModule,
    RouterModule,

    MaterialModule,

    NgbModule,
    FontAwesomeModule,
    // NgxMasonryModule,


    DeleteButtonComponent,
    DetailButtonComponent,
    AddButtonComponent,
    EditButtonComponent,
    AlertComponent,
    YesNoDialogComponent,


  ]
})
export class SharedModule {
}
