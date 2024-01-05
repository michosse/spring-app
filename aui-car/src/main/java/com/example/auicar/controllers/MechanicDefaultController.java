package com.example.auicar.controllers;

import lombok.extern.java.Log;
import com.example.auicar.DTO.MechanicDTOcu;
import com.example.auicar.DTO.MechanicDTOr;
import com.example.auicar.DTO.MechanicsDTOr;
import com.example.auicar.entity.Car;
import com.example.auicar.entity.Mechanic;
import com.example.auicar.service.MechanicDefaultService;
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

    @PutMapping("/mechanic")
    public ResponseEntity<String> CreateMechanic(@RequestBody MechanicDTOcu request){
        Mechanic mechanic = Mechanic.builder()
                .NIP(request.getNip())
                .name(request.getName())
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
