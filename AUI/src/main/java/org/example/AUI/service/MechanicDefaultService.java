package org.example.AUI.service;

import org.example.AUI.entity.Mechanic;
import org.example.AUI.repository.CarRepository;
import org.example.AUI.repository.MechanicRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class MechanicDefaultService {
    private final MechanicRepository repository;

    @Autowired
    public MechanicDefaultService(MechanicRepository repository){
        this.repository=repository;
    }

    public Optional<Mechanic> findByName(String name){
        return repository.findByName(name);
    }
    public List<Mechanic> findAll(){
        return repository.findAll();
    }

    public Optional<Mechanic> find(UUID NIP){
        return repository.findById(NIP);
    }
    public void create(Mechanic mechanic){
        repository.save(mechanic);
    }

    public void delete(Mechanic mechanic){
        repository.findById(mechanic.getNIP()).ifPresent(repository::delete);
    }
}
