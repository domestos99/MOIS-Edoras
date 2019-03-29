import {Component} from '@angular/core';
import {AdminService} from "@app/modules/secure/admin/admin.service";


@Component({
  selector: 'admin',
  templateUrl: 'admin.component.html'
})
export class AdminComponent {

  constructor(private adminService: AdminService) {

  }

  onReloadDataBtnClick() {
    this.adminService.realodDataFromApi()
      .subscribe(resp => {
        alert(resp);
      }, error1 => {
        alert('error - see console for more info or try it again later');
        console.log(error1);
      });

  }
}
