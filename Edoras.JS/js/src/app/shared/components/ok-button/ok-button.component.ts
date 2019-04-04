import {Component, Input, Output, EventEmitter, ViewChild} from '@angular/core';


@Component({
  selector: 'ok-button',
  templateUrl: 'ok-button.component.html'
})
export class OkButtonComponent {


  @Output() onClick: EventEmitter<any> = new EventEmitter();

  onButtonClick() {
    this.onClick.emit(null);
  }

}
