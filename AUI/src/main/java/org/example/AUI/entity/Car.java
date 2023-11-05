package org.example.AUI.entity;


import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.time.LocalDate;
import java.util.Objects;
import java.util.UUID;

@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@EqualsAndHashCode
@Entity
@Table(name = "Cars")
public class Car {
    @Id
    private UUID vin;
    private String brand;
    @Column(name="first_day")
    private LocalDate firstDay;
    @ManyToOne
    @JoinColumn(name = "mechanic")
    private Mechanic mechanic;

    @Override
    public String toString() {
        return "Car{" +
                "vin=" + vin +
                ", brand='" + brand + '\'' +
                ", firstDay=" + firstDay +
                ", mechanic=" + mechanic.getName() +
                '}';
    }
}
