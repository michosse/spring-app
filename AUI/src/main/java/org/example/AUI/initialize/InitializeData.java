package org.example.AUI.initialize;

import org.example.AUI.entity.Car;
import org.example.AUI.entity.Mechanic;
import org.example.AUI.service.CarDefaultService;
import org.example.AUI.service.MechanicDefaultService;
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
                .NIP(UUID.randomUUID())
                .name("Bob")
                .build();
        Mechanic jack = Mechanic.builder()
                .NIP(UUID.randomUUID())
                .name("Jack")
                .build();
        mechanicDefaultService.create(bob);
        mechanicDefaultService.create(jack);
        Car bmw1 = Car.builder()
                .vin(UUID.randomUUID())
                .brand("BMW")
                .firstDay(LocalDate.of(2023,10,15))
                .mechanic(bob)
                .build();
        Car bmw2 = Car.builder()
                .vin(UUID.randomUUID())
                .brand("BMW")
                .firstDay(LocalDate.of(2023,10,12))
                .mechanic(bob)
                .build();
        Car bmw3 = Car.builder()
                .vin(UUID.randomUUID())
                .brand("BMW")
                .firstDay(LocalDate.of(2023,10,19))
                .mechanic(bob)
                .build();
        Car opel1 = Car.builder()
                .vin(UUID.randomUUID())
                .brand("Opel")
                .firstDay(LocalDate.of(2023,10,1))
                .mechanic(jack)
                .build();
        Car ford1 = Car.builder()
                .vin(UUID.randomUUID())
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
