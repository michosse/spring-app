package org.example.AUI.controllers;

import lombok.extern.java.Log;
import org.example.AUI.DTO.CarDTOcu;
import org.example.AUI.DTO.CarDTOr;
import org.example.AUI.DTO.CarsDTOr;
import org.example.AUI.entity.Car;
import org.example.AUI.entity.Mechanic;
import org.example.AUI.service.CarDefaultService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@RestController
@Log
@RequestMapping("/api")
public class CarDefaultController {
    private final CarDefaultService service;

    @Autowired
    public CarDefaultController(CarDefaultService service){
        this.service = service;
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
    public void CreateCar(@RequestBody CarDTOcu request){
        Car car = Car.builder()
                .vin(UUID.randomUUID())
                .brand(request.getBrand())
                .firstDay(request.getFirstDay())
                .mechanic(Mechanic.builder()
                        .NIP(request.getMechanicNip())
                        .build())
                .build();
        service.create(car);
    }
    @PatchMapping("/cars/{vin}")
    public ResponseEntity<String> UpdateCar(@PathVariable ("vin") UUID vin, @RequestBody CarDTOcu request){
        Optional<Car> car = service.find(vin);
        if (car.isPresent()){
            car.get().setBrand(request.getBrand());
            car.get().setFirstDay(request.getFirstDay());
            car.get().setMechanic(Mechanic.builder().NIP(request.getMechanicNip()).build());
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
