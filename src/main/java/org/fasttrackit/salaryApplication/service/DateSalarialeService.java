package org.fasttrackit.salaryApplication.service;

import lombok.Data;
import org.fasttrackit.salaryApplication.model.DateAngajareUnitate;
import org.fasttrackit.salaryApplication.model.DateAngajati;
import org.fasttrackit.salaryApplication.model.DateSalariale;
import org.fasttrackit.salaryApplication.repository.DateAngajatiRepository;
import org.fasttrackit.salaryApplication.repository.DateSalarialeRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Data
public class DateSalarialeService {

    private final DateSalarialeRepository dateSalarialeRepository;
    private DateAngajatiRepository dateAngajatiRepository;

    public DateSalarialeService(DateSalarialeRepository dateSalarialeRepository) {
        this.dateSalarialeRepository = dateSalarialeRepository;
    }

    public List<DateSalariale> getDateSalariale() {
        return dateSalarialeRepository.findAll();
    }
    public DateSalariale getDateSalarialeByMarca(Integer marca) {
        return dateSalarialeRepository.findByMarca(marca);
    }

    public DateSalariale addAngajatNouDateSalariale(DateSalariale angajatNou) {
       DateSalariale completareDateSalarizareAngajatNou = DateSalariale.builder()
                .marca(angajatNou.getMarca())
                .salariuIncadrare(angajatNou.getSalariuIncadrare())
                .alteDrepturi(angajatNou.getAlteDrepturi())
                .ticheteMasa(angajatNou.getTicheteMasa())
                .build();
        return dateSalarialeRepository.save(completareDateSalarizareAngajatNou);
    }
    public DateSalariale deleteDateSalariale(Integer marca){
        DateSalariale dateSalarialePtSters = dateSalarialeRepository.findByMarca(marca);
        dateSalarialeRepository.deleteById(marca);
        return dateSalarialePtSters;
    }

}
