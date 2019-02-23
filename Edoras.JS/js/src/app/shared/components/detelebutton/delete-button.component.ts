import {Component, Input, Output, EventEmitter, ViewChild} from '@angular/core';


@Component({
  selector: 'delete-button',
  templateUrl: 'delete-button.component.html'
})
export class DeleteButtonComponent {


  @Output() onClick: EventEmitter<any> = new EventEmitter();

  onButtonClick() {
    this.onClick.emit(null);
  }

}
