import {Component, Input, Output, EventEmitter, ViewChild} from '@angular/core';


@Component({
  selector: 'my-chart',
  templateUrl: 'my-chart.component.html'
})
export class MyChartComponent {

  @Input() title: any;
  @Input() chartData: any;
  @Input() argumentField: any;
  @Input() valueField: any;

  pointClickHandler(e) {
    this.toggleVisibility(e.target);
  }

  legendClickHandler(e) {
    let arg = e.target,
      item = e.component.getAllSeries()[0].getPointsByArg(arg)[0];

    this.toggleVisibility(item);
  }

  toggleVisibility(item) {
    if (item.isVisible()) {
      item.hide();
    } else {
      item.show();
    }
  }

  customizeLabel(arg) {
    console.log(arg);

    return arg.valueText + " (" + arg.percentText + ")";
  }

}
