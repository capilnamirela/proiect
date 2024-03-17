package org.fasttrackit.salaryApplication.client.model;

import jakarta.persistence.Column;
import jakarta.persistence.Id;
import lombok.Builder;

@Builder
public record DateAngajatiDTO(

    Integer marca,

    String nume,

    String prenume,

    String cnp,

    String adresa
) {}