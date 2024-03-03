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
public class Pontaj {
    @Id
    private Integer marca;
    @Column
    private Integer zileLucratoare;
    @Column
    private Integer zileLucrate;
    @Column
    private Integer zileCO;
    @Column
    private Integer zileCFS;
}
