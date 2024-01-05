package com.example.auicar.controllers;

import com.example.auicar.service.MechanicDefaultService;
import lombok.extern.java.Log;
import com.example.auicar.DTO.CarDTOcu;
import com.example.auicar.DTO.CarDTOr;
import com.example.auicar.DTO.CarsDTOr;
import com.example.auicar.entity.Car;
import com.example.auicar.entity.Mechanic;
import com.example.auicar.service.CarDefaultService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@Log
@RequestMapping("/api")
public class CarDefaultController {
    private final CarDefaultService service;
    private final MechanicDefaultService mechanicService;

    @Autowired
    public CarDefaultController(CarDefaultService service, MechanicDefaultService mechanicService){
        this.service = service;
        this.mechanicService = mechanicService;
    }

    @GetMapping("/cars/{vin}")
    public ResponseEntity<CarDTOr> GetCar(@PathVariable("vin") UUID vin){
        Optional<Car> car = service.find(vin);
        if (car.isPresent()) {
            CarDTOr carDTO = CarDTOr.builder()
                    .vin(car.get().getVin())
                    .brand(car.get().getBrand())
                    .firstDay(car.get().getFirstDay())
                    .mechanicId(car.get().getMechanic().getNIP())
                    .mechanicName(car.get().getMechanic().getName())
                    .build();
            return ResponseEntity.ok(carDTO);
        }
        else {
            return ResponseEntity.notFound().build();
        }
    }
    @GetMapping("/mechanics/{nip}/cars")
    public ResponseEntity<List<CarDTOr>> GerCarsByMechanic(@PathVariable ("nip") UUID nip){
        Optional<List<Car>> cars = service.findAllByMechanic(nip);
        if (cars.isPresent()){
            List<Car> cars1 = cars.get();
            List<CarDTOr> carsDTO = cars1.stream().map(car -> CarDTOr.builder()
                    .vin(car.getVin())
                    .brand(car.getBrand())
                    .firstDay(car.getFirstDay())
                    .mechanicId(car.getMechanic().getNIP())
                    .mechanicName(car.getMechanic().getName())
                    .build()).toList();
            return ResponseEntity.ok(carsDTO);
        }
        else {
            return ResponseEntity.notFound().build();
        }
    }
    @GetMapping("/cars")
    public ResponseEntity<CarsDTOr> GetCars(){
        List<Car> cars = service.findAll();
        CarsDTOr carsDTO = CarsDTOr.builder()
                .cars(cars.stream().map(car -> CarsDTOr.Car.builder()
                        .brand(car.getBrand())
                        .vin(car.getVin())
                        .build()).toList())
                .build();
        return ResponseEntity.ok(carsDTO);
    }
    @PutMapping("/car")
    public ResponseEntity<String> CreateCar(@RequestBody CarDTOcu request){
        Optional<Mechanic> m = mechanicService.find(request.getMechanicNip());
        if (m.isPresent()) {
            Car car = Car.builder()
                    .vin(UUID.randomUUID())
                    .brand(request.getBrand())
                    .firstDay(request.getFirstDay())
                    .mechanic(m.get())
                    .build();
            service.create(car);
            return ResponseEntity.ok("");
        }
        return ResponseEntity.notFound().build();
    }
    @PatchMapping("/cars/{vin}")
    public ResponseEntity<String> UpdateCar(@PathVariable ("vin") UUID vin, @RequestBody CarDTOcu request){
        Optional<Car> car = service.find(vin);
        Optional<Mechanic> m = mechanicService.find(request.getMechanicNip());
        if (car.isPresent()&&m.isPresent()){
            car.get().setBrand(request.getBrand());
            car.get().setFirstDay(request.getFirstDay());
            car.get().setMechanic(m.get());
            service.update(car.get());
            return ResponseEntity.ok("");
        }
        else {
            return ResponseEntity.notFound().build();
        }
    }
    @DeleteMapping("/cars/{vin}")
    public ResponseEntity<String> DeleteCar(@PathVariable ("vin") UUID vin){
        Optional<Car> car = service.find(vin);
        if (car.isPresent()){
            service.delete(vin);
            return ResponseEntity.ok("");
        }
        else {
            return ResponseEntity.notFound().build();
        }
    }
}
