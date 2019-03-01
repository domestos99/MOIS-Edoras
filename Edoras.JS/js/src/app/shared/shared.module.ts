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

    AddButtonComponent
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
    AlertComponent,


  ]
})
export class SharedModule {
}