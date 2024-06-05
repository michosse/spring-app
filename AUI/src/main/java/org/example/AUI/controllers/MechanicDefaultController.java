package org.example.AUI.controllers;

import lombok.extern.java.Log;
import org.example.AUI.DTO.MechanicDTOcu;
import org.example.AUI.DTO.MechanicDTOr;
import org.example.AUI.DTO.MechanicsDTOr;
import org.example.AUI.entity.Car;
import org.example.AUI.entity.Mechanic;
import org.example.AUI.service.CarDefaultService;
import org.example.AUI.service.MechanicDefaultService;
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
public class MechanicDefaultController {

    private final MechanicDefaultService service;

    @Autowired
    public MechanicDefaultController(MechanicDefaultService service){
        this.service = service;
    }

    @GetMapping("mechanics/{nip}")
    public ResponseEntity<MechanicDTOr> GetMechanic(@PathVariable ("nip")UUID nip){
        Optional<Mechanic> mechanic = service.find(nip);
        if (mechanic.isPresent()){
            MechanicDTOr mechanicDTO = MechanicDTOr.builder()
                    .NIP(mechanic.get().getNIP())
                    .name(mechanic.get().getName())
                    .cars(mechanic.get().getCars().stream().map(car -> car.getBrand()+": "+car.getVin().toString()).toList())
                    .build();
            return ResponseEntity.ok(mechanicDTO);
        }
        else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/mechanics")
    public ResponseEntity<MechanicsDTOr> GetMechanics(){
        List<Mechanic> mechs = service.findAll();
        MechanicsDTOr mechanicsDTOr = MechanicsDTOr.builder()
                .mechanics(mechs.stream().map(mechanic -> MechanicsDTOr.Mechanic.builder()
                        .name(mechanic.getName())
                        .NIP(mechanic.getNIP())
                        .build()).toList())
                .build();
        return ResponseEntity.ok(mechanicsDTOr);
    }

    @PutMapping("/mechanic")
    public ResponseEntity<String> CreateMechanic(@RequestBody MechanicDTOcu request){
        Mechanic mechanic = Mechanic.builder()
                .NIP(UUID.randomUUID())
                .name(request.getName())
                .cars(request.getCars().stream().map(req -> Car.builder().vin(req).build()).collect(Collectors.toList()))
                .build();
        service.create(mechanic);
        return ResponseEntity.ok("");
    }

    @DeleteMapping("/mechanics/{nip}")
    public ResponseEntity<String> DeleteMechanic(@PathVariable ("nip") UUID nip){
        Optional<Mechanic> mechanic = service.find(nip);
        if (mechanic.isPresent()){
            service.delete(mechanic.get());
            return ResponseEntity.ok("");
        }
        else {
            return ResponseEntity.notFound().build();
        }
    }

}
