import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {MechanicCar} from "../model/mechanic-car";
import {CarAdd} from "../model/car-add";

@Injectable()
export class CarService {

  constructor(private http: HttpClient) {  }
  getMechanicCars(id:string):Observable<MechanicCar[]>{
    return this.http.get<MechanicCar[]>('http://localhost:8082/api/mechanics/'+id+'/cars');
  }
  getCar(id:string):Observable<MechanicCar>{
    return this.http.get<MechanicCar>('http://localhost:8082/api/cars/'+id);
  }
  deleteCar(id: string):Observable<any>{
    return this.http.delete('http://localhost:8082/api/cars/'+id);
  }
  addCar(request: CarAdd):Observable<any>{
    return this.http.put('http://localhost:8082/api/car',request);
  }
  updateCar(id: string, request: CarAdd):Observable<any>{
    return this.http.patch('http://localhost:8082/api/cars/'+id,request);
  }
}
