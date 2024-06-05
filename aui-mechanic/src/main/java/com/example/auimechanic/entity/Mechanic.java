package com.example.auimechanic.entity;

import jakarta.persistence.*;
import lombok.*;

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
}
