package org.fasttrackit.salaryApplication.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

@Builder
@With
@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
public class DateAngajati {
    @Id
    private Integer marca;
    @Column
    private String nume;
    @Column
    private String prenume;
    @Column
    private String cnp;
    @Column
    private String adresa;

    @JsonIgnore
    @OneToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REMOVE})
    private DateAngajareUnitate dateAngajareUnitate;

    @JsonIgnore
    @OneToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REMOVE})
    private DateSalariale dateSalariale;

    @JsonIgnore
    @OneToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REMOVE})
    private Pontaj pontaj;

}


