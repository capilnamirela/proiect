package org.fasttrackit.salaryApplication.client.model;

import lombok.Builder;

@Builder
public record DateAngajatiDTO(
        Integer marca,
        String nume,
        String prenume,
        String cnp,
        String adresa
) {
}
