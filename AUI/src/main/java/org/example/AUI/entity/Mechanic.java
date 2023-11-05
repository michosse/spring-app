package org.example.AUI.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.*;

import java.io.Serializable;
import java.util.List;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@EqualsAndHashCode
@Builder
@Entity
@Table(name = "mechanics")
public class Mechanic {
    @Id
    private UUID NIP;
    private String name;
    @OneToMany(mappedBy = "mechanic")
    private List<Car> cars;

    @Override
    public String toString() {
        String carsString = "";
        for (Car c : this.cars){
            carsString += c.getBrand() + "\n";
        }
        return "Mechanic{" +
                "NIP=" + NIP +
                ", name='" + name + '\'' +
                ", cars=" + carsString;
    }
}
