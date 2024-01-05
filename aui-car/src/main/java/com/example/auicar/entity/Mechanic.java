package com.example.auicar.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@ToString
@EqualsAndHashCode
@Builder
@Entity
@Table(name = "mechanics")
public class Mechanic {
    @Id
    private UUID NIP;
    private String name;
    @OneToMany(mappedBy = "mechanic", cascade = CascadeType.REMOVE)
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    private List<Car> cars;

}
