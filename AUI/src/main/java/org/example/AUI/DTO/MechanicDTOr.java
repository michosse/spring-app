package org.example.AUI.DTO;

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
public class MechanicDTOr {
    private UUID NIP;
    private String name;
    private List<String> cars;
}
