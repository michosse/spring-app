package com.example.auimechanic.controllers;

import com.example.auimechanic.DTO.MechanicDTOs;
import lombok.extern.java.Log;
import com.example.auimechanic.DTO.MechanicDTOcu;
import com.example.auimechanic.DTO.MechanicDTOr;
import com.example.auimechanic.DTO.MechanicsDTOr;
import com.example.auimechanic.entity.Mechanic;
import com.example.auimechanic.service.MechanicDefaultService;
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
@CrossOrigin(origins = "*")
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
                .build();
        service.create(mechanic);
        return ResponseEntity.ok("");
    }

    @PatchMapping("/mechanic/{nip}")
    public ResponseEntity<String> UpdateMechanic(@PathVariable ("nip")UUID nip, @RequestBody MechanicDTOcu request){
        Optional<Mechanic> m = service.find(nip);
        if (m.isPresent()){
            Mechanic mechanic = Mechanic.builder()
                    .NIP(nip)
                    .name(request.getName())
                    .build();
            service.create(mechanic);
            return ResponseEntity.ok("");
        }
        return ResponseEntity.notFound().build();
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
