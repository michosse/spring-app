package com.example.auimechanic.service;

import com.example.auimechanic.entity.Mechanic;
import com.example.auimechanic.event.MechanicEventRestRepository;
import com.example.auimechanic.repository.MechanicRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class MechanicDefaultService {
    private final MechanicRepository repository;
    private final MechanicEventRestRepository restRepository;

    @Autowired
    public MechanicDefaultService(MechanicRepository repository, MechanicEventRestRepository restRepository){
        this.repository = repository;
        this.restRepository = restRepository;
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
        restRepository.save(mechanic);
    }
    public void init(Mechanic mechanic){
        repository.save(mechanic);
    }
    public void delete(Mechanic mechanic){
        Optional<Mechanic> m = repository.findById(mechanic.getNIP());
        if (m.isPresent()) {
            repository.delete(m.get());
            restRepository.delete(m.get().getNIP());
        }
    }
}
