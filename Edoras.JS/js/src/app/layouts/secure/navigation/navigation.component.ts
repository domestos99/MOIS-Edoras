import { Component } from '@angular/core';
import { NavigationService } from './navigation.service';

@Component({
  selector: 'navigation',
  templateUrl: 'navigation.component.html'
})

export class NavigationComponent {

  constructor(public nav: NavigationService) { }
}
