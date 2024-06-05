import {Component, OnInit} from '@angular/core';
import {MechanicService} from "../../../mechanic/service/mechanic.service";
import {ActivatedRoute, Router} from "@angular/router";
import {CarService} from "../../service/car.service";
import {CarAdd} from "../../model/car-add";
import {Mechanics} from "../../../mechanic/model/mechanics";

@Component({
  selector: 'app-car-add',
  templateUrl: './car-add.component.html',
  styleUrls: ['./car-add.component.css']
})
export class CarAddComponent implements OnInit{
  brand: string | undefined;
  firstDay: string|undefined;
  mechanicNip: string | undefined;
  mechanics: Mechanics|undefined;
  constructor(private serviceMec: MechanicService,private serviceCar: CarService, private route: ActivatedRoute, private router: Router) {
  }
  ngOnInit() {
    this.serviceMec.getMechanics().subscribe(mechanics => this.mechanics=mechanics)
  }

  onSubmit(){
    this.route.params.subscribe(params => {
      this.serviceCar.addCar(new CarAdd(this.brand!,this.firstDay!,this.mechanicNip!)).subscribe(()=> this.router.navigate(['']));
    })
  }
}
