package com.example.auicar.DTO;


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
public class MechanicDTOcu {
    private UUID nip;
    private String name;
    private List<UUID> cars;
}
