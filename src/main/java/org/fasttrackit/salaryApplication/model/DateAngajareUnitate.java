package org.fasttrackit.salaryApplication.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
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

