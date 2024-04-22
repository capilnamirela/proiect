package org.fasttrackit.salaryApplication.client.mapper;

import org.fasttrackit.salaryApplication.client.model.DateSalarialeDTO;
import org.fasttrackit.salaryApplication.model.DateSalariale;
import org.springframework.stereotype.Component;

@Component
public class DateSalarialeMapper {

    public static DateSalarialeDTO toDtoDateSalariale(DateSalariale dateSalariale) {
        return DateSalarialeDTO.builder()
                .marca(dateSalariale.getMarca())
                .salariuIncadrare(dateSalariale.getSalariuIncadrare())
                .alteDrepturi(dateSalariale.getAlteDrepturi())
                .ticheteMasa(dateSalariale.getTicheteMasa())
                .build();
    }

    public static DateSalarialeDTO toDtoUpdateDateSalariale(Integer marca, DateSalariale dateSalariale) {
        return DateSalarialeDTO.builder()
                .salariuIncadrare(dateSalariale.getSalariuIncadrare())
                .alteDrepturi(dateSalariale.getAlteDrepturi())
                .ticheteMasa(dateSalariale.getTicheteMasa())
                .build();
    }


    public static DateSalariale toEntityDateSalariale(DateSalarialeDTO dateSalarialeDTO) {
        return DateSalariale.builder()
                .marca(dateSalarialeDTO.marca())
                .salariuIncadrare(dateSalarialeDTO.salariuIncadrare())
                .alteDrepturi(dateSalarialeDTO.alteDrepturi())
                .ticheteMasa(dateSalarialeDTO.ticheteMasa())
                .build();
    }
}
