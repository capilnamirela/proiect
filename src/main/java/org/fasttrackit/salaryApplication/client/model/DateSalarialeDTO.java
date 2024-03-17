package org.fasttrackit.salaryApplication.client.model;

import lombok.Builder;

@Builder
public record DateSalarialeDTO(
        Integer marca,
        Integer salariuIncadrare,
        Integer alteDrepturi,
        Integer ticheteMasa
) {
}
