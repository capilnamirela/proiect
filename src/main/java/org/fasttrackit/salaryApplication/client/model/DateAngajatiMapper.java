package org.fasttrackit.salaryApplication.client.model;

import org.fasttrackit.salaryApplication.model.DateAngajareUnitate;
import org.fasttrackit.salaryApplication.model.DateAngajati;

import java.time.LocalDate;

public class DateAngajatiMapper {

    public static DateAngajatiDTO toDtoDateAngajati(DateAngajati dateAngajati) {
        return DateAngajatiDTO.builder()
                .marca(dateAngajati.getMarca())
                .nume(dateAngajati.getNume())
                .prenume(dateAngajati.getPrenume())
                .cnp(dateAngajati.getCnp())
                .adresa(dateAngajati.getAdresa())
                .build();
    }

    public static DateAngajatiDTO toDtoUpdateDateAngajati(Integer marca, DateAngajati dateAngajati) {
        return DateAngajatiDTO.builder()
                .nume(dateAngajati.getNume())
                .prenume(dateAngajati.getPrenume())
                .cnp(dateAngajati.getCnp())
                .adresa(dateAngajati.getAdresa())
                .build();
    }


    public static DateAngajati toEntityDateAngajati(DateAngajatiDTO dateAngajatiDTO) {
        return DateAngajati.builder()
                .marca(dateAngajatiDTO.marca())
                .nume(dateAngajatiDTO.nume())
                .prenume(dateAngajatiDTO.prenume())
                .cnp(dateAngajatiDTO.cnp())
                .adresa(dateAngajatiDTO.adresa())
                .build();
    }

}
