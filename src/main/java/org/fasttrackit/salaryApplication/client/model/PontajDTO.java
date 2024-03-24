package org.fasttrackit.salaryApplication.client.model;

import lombok.Builder;

@Builder
public record PontajDTO(
        Integer marca,
        Integer zileLucratoare,
        Integer zileLucrate,
        Integer zileCO,
        Integer zileCFS
) {
}
