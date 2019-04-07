import {Component, Input, Output, EventEmitter, ViewChild} from '@angular/core';


@Component({
  selector: 'spinner',
  templateUrl: 'spinner.component.html',
  styleUrls: ['./spinner.component.css']
})
export class SpinnerComponent {

  @Input()
  set diameterSize(val: string) {
    if (val) {
      if (val == 'small') {
        this.diameter = 30;
        return;
      }
    }
    this.diameter = 100;
  }

  diameter: number = 100;
}
