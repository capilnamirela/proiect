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
    @Column
    private Integer copiiMinori;

    @JsonIgnore
    @OneToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REMOVE})
    @JoinColumn(name = "marca")
    private DateAngajareUnitate dateAngajareUnitate;

    @JsonIgnore
    @OneToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REMOVE})
    @JoinColumn(name = "marca")
    private DateSalariale dateSalariale;

    @JsonIgnore
    @OneToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REMOVE})
    @JoinColumn(name = "marca")
    private Pontaj pontaj;

}


