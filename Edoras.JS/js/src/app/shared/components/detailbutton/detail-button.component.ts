import {Component, Input, Output, EventEmitter, ViewChild} from '@angular/core';


@Component({
  selector: 'detail-button',
  templateUrl: 'detail-button.component.html'
})
export class DetailButtonComponent {


  @Output() onClick: EventEmitter<any> = new EventEmitter();

  onButtonClick() {
    this.onClick.emit(null);
  }

}
