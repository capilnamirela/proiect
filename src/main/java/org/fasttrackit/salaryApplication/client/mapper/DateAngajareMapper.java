package org.fasttrackit.salaryApplication.client.mapper;

import org.fasttrackit.salaryApplication.client.model.DateAngajareDTO;
import org.fasttrackit.salaryApplication.model.DateAngajareUnitate;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Component
public class DateAngajareMapper {
    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    public static DateAngajareDTO toDto(DateAngajareUnitate dateAngajareUnitate) {
        return DateAngajareDTO.builder()
                .marca(dateAngajareUnitate.getMarca())
                .dataAngajare(dateAngajareUnitate.getDataAngajariiUnitate().toString())
                .departament(dateAngajareUnitate.getDepartament())
                .functie(dateAngajareUnitate.getFunctie())
                .build();
    }

    public static DateAngajareDTO toDtoUpdate(Integer marca, DateAngajareUnitate dateAngajareUnitate) {
        return DateAngajareDTO.builder()
                .dataAngajare(dateAngajareUnitate.getDataAngajariiUnitate().toString())
                .departament(dateAngajareUnitate.getDepartament())
                .functie(dateAngajareUnitate.getFunctie())
                .build();
    }


    public static DateAngajareUnitate toEntity(DateAngajareDTO dateAngajareDTO) {
        return DateAngajareUnitate.builder()
                .marca(dateAngajareDTO.marca())
                .dataAngajariiUnitate(LocalDate.parse(dateAngajareDTO.dataAngajare(), formatter))
                .departament(dateAngajareDTO.departament())
                .functie(dateAngajareDTO.functie())
                .build();
    }


}
