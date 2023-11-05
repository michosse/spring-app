package org.example.AUI.service;

import org.example.AUI.entity.Car;
import org.example.AUI.repository.CarRepository;
import org.example.AUI.repository.MechanicRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class CarDefaultService {
    private final CarRepository repository;
    private final MechanicRepository mechanicRepository;

    @Autowired
    public CarDefaultService(
            CarRepository repository,
            MechanicRepository mechanicRepository
    ){
        this.repository=repository;
        this.mechanicRepository=mechanicRepository;
    }

    public Optional<Car> find(UUID vin){
        return repository.findById(vin);
    }
    public List<Car> findAll(){
        return repository.findAll();
    }
    public Optional<List<Car>> findAllByMechanic(UUID NIP){
        return mechanicRepository.findById(NIP)
                .map(repository::findAllByMechanic);
    }
    public void create(Car car){
        repository.save(car);
    }
    public void update(Car car){
        repository.save(car);
    }
    public void delete(UUID vin){
        repository.findById(vin).ifPresent(repository::delete);
    }
}
