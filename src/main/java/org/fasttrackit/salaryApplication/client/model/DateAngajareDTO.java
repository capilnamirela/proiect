package org.fasttrackit.salaryApplication.client.model;

import lombok.Builder;

@Builder
public record DateAngajareDTO(
        Integer marca,
        String dataAngajare,
        String departament,
        String functie


) {
}
