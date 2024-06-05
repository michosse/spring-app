import {Component, OnInit} from '@angular/core';
import {MechanicService} from "../../../mechanic/service/mechanic.service";
import {ActivatedRoute, Router} from "@angular/router";
import {CarService} from "../../service/car.service";
import {CarAdd} from "../../model/car-add";
import {Mechanics} from "../../../mechanic/model/mechanics";

@Component({
  selector: 'app-car-edit',
  templateUrl: './car-edit.component.html',
  styleUrls: ['./car-edit.component.css']
})
export class CarEditComponent implements OnInit{
  brand: string | undefined;
  firstDay: string|undefined;
  mechanicNip: string | undefined;
  carid: string|undefined;
  mechanics: Mechanics|undefined;
  constructor(private serviceMec: MechanicService,private service: CarService, private router: Router, private route: ActivatedRoute) {
  }
  ngOnInit() {
    this.route.params.subscribe(params => {
      this.service.getCar(params['id']).subscribe(car => {
        this.brand=car.brand;
        this.firstDay=car.firstDay;
        this.mechanicNip=car.mechanicId
        this.carid=params['id'];
        this.serviceMec.getMechanics().subscribe(mechanics => this.mechanics=mechanics)
      })
    })
  }
  onSubmit(){
    this.service.updateCar(this.carid!,new CarAdd(this.brand!,this.firstDay!,this.mechanicNip!)).subscribe(() => this.router.navigate(['/mechanics',this.mechanicNip,'details']));
  }
}
