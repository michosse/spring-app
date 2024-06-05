import {Component, OnInit} from '@angular/core';
import {MechanicService} from "../../service/mechanic.service";
import {ActivatedRoute, Router} from "@angular/router";
import {Mechanicadd} from "../../model/mechanicadd";

@Component({
  selector: 'app-mechanicedit',
  templateUrl: './mechanicedit.component.html',
  styleUrls: ['./mechanicedit.component.css']
})
export class MechaniceditComponent implements OnInit{

  name: string | undefined;
  nip: string | undefined;
  constructor(private service: MechanicService, private router: Router, private route: ActivatedRoute) {
  }

  ngOnInit() {
    this.route.params.subscribe(params => {
      this.service.getMechanic(params['id']).subscribe(mechanic =>{
        this.name=mechanic.name;
        this.nip=mechanic.nip;
      })
    })
  }
  onSubmit():void{
    this.service.updateMechanic(this.nip!,new Mechanicadd(this.name!,[])).subscribe(()=> this.router.navigate(['']));
  }
}
