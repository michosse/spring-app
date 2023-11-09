package org.example.AUI.DTO;

import lombok.*;

import java.time.LocalDate;
import java.util.UUID;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
public class CarDTOcu {
    private String brand;
    private LocalDate firstDay;
    private UUID mechanicNip;
}
