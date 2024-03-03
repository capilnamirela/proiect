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
public class DateSalariale {
    @Id
    private Integer marca;
    @Column
    private Integer salariuIncadrare;
    @Column
    private Integer alteDrepturi;
    @Column
    private Integer ticheteMasa;
}
