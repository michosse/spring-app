package com.example.auimechanic.event;

import com.example.auimechanic.DTO.MechanicDTOcu;
import com.example.auimechanic.DTO.MechanicDTOs;
import com.example.auimechanic.entity.Mechanic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

import java.util.UUID;

@Repository
public class MechanicEventRestRepository {
    private final RestTemplate restTemplate;

    @Autowired
    public MechanicEventRestRepository(RestTemplate template){
        this.restTemplate = template;
    }

    public void delete(UUID id){
        restTemplate.delete("/api/mechanics/{nip}",id);
    }
    public void save(Mechanic m){
        MechanicDTOs mDTO = MechanicDTOs.builder()
                .nip(m.getNIP())
                .name(m.getName())
                .build();
        restTemplate.put("/api/mechanic",mDTO);
    }

}
