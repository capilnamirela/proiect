package org.fasttrackit.salaryApplication.service;

import lombok.Data;
import org.fasttrackit.salaryApplication.exceptions.ResourceNotFoundException;
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
        DateSalariale dateSalariale = dateSalarialeRepository.findById(marca)
                .orElseThrow(() -> new ResourceNotFoundException("Datele salariale pentru angajatul cu marca: %s nu au fost gasite".formatted(marca)));
        return dateSalariale;
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

    public DateSalariale updateDateSalariale(Integer marca, DateSalariale updateDateSalariale) {
        DateSalariale foundDateSalariale = getDateSalarialeByMarca(marca);
        DateSalariale updatedDateSalariale = DateSalariale.builder()
                .marca(foundDateSalariale.getMarca())
                .salariuIncadrare(updateDateSalariale.getSalariuIncadrare())
                .alteDrepturi(updateDateSalariale.getAlteDrepturi())
                .ticheteMasa(updateDateSalariale.getTicheteMasa())
                .build();
        return dateSalarialeRepository.save(updatedDateSalariale);
    }

    public DateSalariale deleteDateSalariale(Integer marca) {
        DateSalariale dateSalarialePtSters = dateSalarialeRepository.findByMarca(marca);
        dateSalarialeRepository.deleteById(marca);
        return dateSalarialePtSters;
    }

}
