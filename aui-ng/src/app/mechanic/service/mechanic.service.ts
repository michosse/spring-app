import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {Mechanics} from "../model/mechanics";
import {Mechanicadd} from "../model/mechanicadd";
import {Mechanic} from "../model/mechanic";

@Injectable()
export class MechanicService {

  constructor(private http: HttpClient) { }

  getMechanics(): Observable<Mechanics>{
    return this.http.get<Mechanics>('http://localhost:8083/api/mechanics');
  }
  getMechanic(id: string): Observable<Mechanic>{
    return this.http.get<Mechanic>('http://localhost:8083/api/mechanics/'+id);
  }
  deleteMechanic(id: string):Observable<any>{
    return this.http.delete('http://localhost:8083/api/mechanics/'+id);
  }
  addMechanic(request: Mechanicadd): Observable<any>{
    return this.http.put('http://localhost:8083/api/mechanic',request);
  }
  updateMechanic(id:string,request: Mechanicadd):Observable<any>{
    return this.http.patch('http://localhost:8083/api/mechanic/'+id,request);
  }
}
