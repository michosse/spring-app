import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppComponent } from './app.component';
import { MechanicviewComponent } from './mechanic/view/mechanicview/mechanicview.component';
import {MechanicService} from "./mechanic/service/mechanic.service";
import {HttpClientModule} from "@angular/common/http";
import { AppRoutingModule } from './app-routing.module';
import { MechanicaddComponent } from './mechanic/view/mechanicadd/mechanicadd.component';
import {FormsModule} from "@angular/forms";
import { MechaniceditComponent } from './mechanic/view/mechanicedit/mechanicedit.component';
import { MechanicdetailsComponent } from './mechanic/view/mechanicdetails/mechanicdetails.component';
import {CarService} from "./car/service/car.service";
import { CarAddComponent } from './car/view/car-add/car-add.component';
import { CarEditComponent } from './car/view/car-edit/car-edit.component';
import { CarDetailsComponent } from './car/view/car-details/car-details.component';

@NgModule({
  declarations: [
    AppComponent,
    MechanicviewComponent,
    MechanicaddComponent,
    MechaniceditComponent,
    MechanicdetailsComponent,
    CarAddComponent,
    CarEditComponent,
    CarDetailsComponent
  ],
  imports: [
    BrowserModule,
    HttpClientModule,
    AppRoutingModule,
    FormsModule
  ],
  providers: [
    MechanicService,
    CarService
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
