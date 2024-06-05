import {Component, OnInit} from '@angular/core';
import {MechanicService} from "../../service/mechanic.service";
import {Mechanics} from "../../model/mechanics";
import {Mechanic} from "../../model/mechanic";

@Component({
  selector: 'app-mechanicview',
  templateUrl: './mechanicview.component.html',
  styleUrls: ['./mechanicview.component.css']
})
export class MechanicviewComponent implements OnInit{
  constructor(private service: MechanicService) {
  }

  mechanics: Mechanics | undefined;
  ngOnInit(){
    this.service.getMechanics().subscribe(mechanics => this.mechanics=mechanics);
  }
  onDelete(mechanic: Mechanic){
    this.service.deleteMechanic(mechanic.nip).subscribe(() => this.ngOnInit());
  }
}
