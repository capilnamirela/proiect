package org.fasttrackit.salaryApplication.client.model;

import jakarta.persistence.Column;
import jakarta.persistence.Id;
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
