import {Component, Input, Output, EventEmitter, ViewChild} from '@angular/core';


@Component({
  selector: 'add-button',
  templateUrl: 'add-button.component.html'
})
export class AddButtonComponent {


  @Output() onClick: EventEmitter<any> = new EventEmitter();

  onButtonClick() {
    this.onClick.emit(null);
  }

}
