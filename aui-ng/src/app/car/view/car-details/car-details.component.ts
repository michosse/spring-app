import {Component, OnInit} from '@angular/core';
import {CarService} from "../../service/car.service";
import {MechanicService} from "../../../mechanic/service/mechanic.service";
import {ActivatedRoute, Router} from "@angular/router";
import {MechanicCar} from "../../model/mechanic-car";

@Component({
  selector: 'app-car-details',
  templateUrl: './car-details.component.html',
  styleUrls: ['./car-details.component.css']
})
export class CarDetailsComponent implements OnInit{
  car: MechanicCar|undefined;
  constructor(private service: CarService, private router: Router, private route: ActivatedRoute) {
  }
  ngOnInit() {
    this.route.params.subscribe(params => {
      this.service.getCar(params['id']).subscribe(car => this.car=car);
    })
  }
}
