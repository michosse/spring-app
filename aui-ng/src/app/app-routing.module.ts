import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import {MechanicviewComponent} from "./mechanic/view/mechanicview/mechanicview.component";
import {MechanicaddComponent} from "./mechanic/view/mechanicadd/mechanicadd.component";
import {MechaniceditComponent} from "./mechanic/view/mechanicedit/mechanicedit.component";
import {MechanicdetailsComponent} from "./mechanic/view/mechanicdetails/mechanicdetails.component";
import {CarAddComponent} from "./car/view/car-add/car-add.component";
import {CarEditComponent} from "./car/view/car-edit/car-edit.component";
import {CarDetailsComponent} from "./car/view/car-details/car-details.component";

const routes: Routes = [
  {path: '', component: MechanicviewComponent},
  {path: 'mechanics/add', component: MechanicaddComponent},
  {path: 'mechanics/:id/edit', component: MechaniceditComponent},
  {path: 'mechanics/:id/details', component: MechanicdetailsComponent},
  {path: 'cars/add', component: CarAddComponent},
  {path: 'cars/:id/edit', component: CarEditComponent},
  {path: 'mechanics/:nip/cars/:id/details', component: CarDetailsComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
