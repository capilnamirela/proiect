package org.fasttrackit.salaryApplication.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;

import java.time.LocalDate;

@Builder
@With
@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
public class DateAngajareUnitate {
    @Id
    private Integer marca;
    @Column
    private LocalDate dataAngajariiUnitate;
    @Column
    private String departament;
    @Column
    private String functie;


}

