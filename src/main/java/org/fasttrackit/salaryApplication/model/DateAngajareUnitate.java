package org.fasttrackit.salaryApplication.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;

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
    private String dataAngajariiUnitate;
    @Column
    private String departament;
    @Column
    private String functie;
}

