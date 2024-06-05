import {Component, OnInit} from '@angular/core';
import {MechanicService} from "../../service/mechanic.service";
import {ActivatedRoute, Router} from "@angular/router";
import {MechanicCar} from "../../../car/model/mechanic-car";
import {CarService} from "../../../car/service/car.service";
import {Mechanic} from "../../model/mechanic";

@Component({
  selector: 'app-mechanicdetails',
  templateUrl: './mechanicdetails.component.html',
  styleUrls: ['./mechanicdetails.component.css']
})
export class MechanicdetailsComponent implements OnInit{
  cars: MechanicCar[] | undefined;
  mechanic: Mechanic | undefined;
  constructor(private serviceCar: CarService, private serviceMec: MechanicService, private router: Router, private route: ActivatedRoute) {
  }
  ngOnInit() {
    this.route.params.subscribe(params=>{
      this.serviceMec.getMechanic(params['id']).subscribe(mechanic => this.mechanic=mechanic);
      this.serviceCar.getMechanicCars(params['id']).subscribe(cars => this.cars=cars);
    })
  }
  onDelete(car: MechanicCar){
    this.serviceCar.deleteCar(car.vin).subscribe(()=>window.location.reload());
  }
}
