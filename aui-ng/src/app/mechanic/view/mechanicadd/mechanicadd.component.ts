import {Component, OnInit} from '@angular/core';
import {MechanicService} from "../../service/mechanic.service";
import {ActivatedRoute, Router} from "@angular/router";
import {Mechanicadd} from "../../model/mechanicadd";

@Component({
  selector: 'app-mechanicadd',
  templateUrl: './mechanicadd.component.html',
  styleUrls: ['./mechanicadd.component.css']
})
export class MechanicaddComponent{
  name: string | undefined;
  cars: string[]=[];
  constructor(private service: MechanicService, private route: ActivatedRoute, private router: Router) {
  }
  onSubmit(){
    this.service.addMechanic(new Mechanicadd(this.name!,this.cars)).subscribe(()=> this.router.navigate(['']))
  }
}
