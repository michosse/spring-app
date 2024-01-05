package com.example.auimechanic.initialize;

import com.example.auimechanic.entity.Mechanic;
import com.example.auimechanic.service.MechanicDefaultService;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class InitializeData implements InitializingBean {
    private final MechanicDefaultService mechanicDefaultService;

    public InitializeData(
            MechanicDefaultService mechanicDefaultService
    ){
        this.mechanicDefaultService = mechanicDefaultService;
    }
    @Override
    public void afterPropertiesSet(){
        Mechanic bob = Mechanic.builder()
                .NIP(UUID.fromString("e4ae979c-8a3b-11ee-b9d1-0242ac120002"))
                .name("Bob")
                .build();
        Mechanic jack = Mechanic.builder()
                .NIP(UUID.fromString("ed8e72a6-8a3b-11ee-b9d1-0242ac120002"))
                .name("Jack")
                .build();
        mechanicDefaultService.create(bob);
        mechanicDefaultService.create(jack);
    }
}
