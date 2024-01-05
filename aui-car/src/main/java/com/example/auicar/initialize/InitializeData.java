package com.example.auicar.initialize;

import com.example.auicar.entity.Car;
import com.example.auicar.entity.Mechanic;
import com.example.auicar.service.CarDefaultService;
import com.example.auicar.service.MechanicDefaultService;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.UUID;

@Component
public class InitializeData implements InitializingBean {
    private final CarDefaultService carDefaultService;
    private final MechanicDefaultService mechanicDefaultService;

    public InitializeData(
            CarDefaultService carDefaultService,
            MechanicDefaultService mechanicDefaultService
    ){
        this.carDefaultService = carDefaultService;
        this.mechanicDefaultService = mechanicDefaultService;
    }
    @Override
    public void afterPropertiesSet() throws Exception {
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
        Car bmw1 = Car.builder()
                .vin(UUID.fromString("19bd9c32-8a3f-11ee-b9d1-0242ac120002"))
                .brand("BMW")
                .firstDay(LocalDate.of(2023,10,15))
                .mechanic(bob)
                .build();
        Car bmw2 = Car.builder()
                .vin(UUID.fromString("26dff66c-8a3f-11ee-b9d1-0242ac120002"))
                .brand("BMW")
                .firstDay(LocalDate.of(2023,10,12))
                .mechanic(bob)
                .build();
        Car bmw3 = Car.builder()
                .vin(UUID.fromString("2dcaf918-8a3f-11ee-b9d1-0242ac120002"))
                .brand("BMW")
                .firstDay(LocalDate.of(2023,10,19))
                .mechanic(bob)
                .build();
        Car opel1 = Car.builder()
                .vin(UUID.fromString("344ea5b4-8a3f-11ee-b9d1-0242ac120002"))
                .brand("Opel")
                .firstDay(LocalDate.of(2023,10,1))
                .mechanic(jack)
                .build();
        Car ford1 = Car.builder()
                .vin(UUID.fromString("39c5ce3c-8a3f-11ee-b9d1-0242ac120002"))
                .brand("Ford")
                .firstDay(LocalDate.of(2023,10,2))
                .mechanic(jack)
                .build();
        carDefaultService.create(bmw1);
        carDefaultService.create(bmw2);
        carDefaultService.create(bmw3);
        carDefaultService.create(opel1);
        carDefaultService.create(ford1);
    }
}
