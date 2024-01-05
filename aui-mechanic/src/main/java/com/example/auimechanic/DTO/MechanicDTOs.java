package com.example.auimechanic.DTO;

import lombok.*;

import java.util.List;
import java.util.UUID;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
public class MechanicDTOs {
    private UUID nip;
    private String name;
    private List<UUID> cars;
}
