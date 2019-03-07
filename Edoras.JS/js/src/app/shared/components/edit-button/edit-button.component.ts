import {Component, Input, Output, EventEmitter, ViewChild} from '@angular/core';


@Component({
  selector: 'edit-button',
  templateUrl: 'edit-button.component.html'
})
export class EditButtonComponent {


  @Output() onClick: EventEmitter<any> = new EventEmitter();

  onButtonClick() {
    this.onClick.emit(null);
  }

}
