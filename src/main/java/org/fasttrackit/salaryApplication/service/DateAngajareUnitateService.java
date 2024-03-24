package org.fasttrackit.salaryApplication.service;

import lombok.Data;
import org.fasttrackit.salaryApplication.exceptions.ResourceNotFoundException;
import org.fasttrackit.salaryApplication.model.DateAngajareUnitate;
import org.fasttrackit.salaryApplication.repository.DateAngajareUnitateRepository;
import org.fasttrackit.salaryApplication.repository.DateAngajatiRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Data
public class DateAngajareUnitateService {

    private DateAngajatiRepository dateAngajatiRepository;
    private final DateAngajareUnitateRepository dateAngajareUnitateRepository;

    public DateAngajareUnitateService(DateAngajareUnitateRepository dateAngajareUnitateRepository) {
        this.dateAngajareUnitateRepository = dateAngajareUnitateRepository;
    }

    public List<DateAngajareUnitate> getDateAngajareUnitate() {
        return dateAngajareUnitateRepository.findAll();
    }

    public DateAngajareUnitate getDateAngajareByMarca(Integer marca) {
        DateAngajareUnitate dateAngajareUnitate = dateAngajareUnitateRepository.findById(marca)
                .orElseThrow(() -> new ResourceNotFoundException("Datele pentru angajatul cu marca: %s nu au fost gasite".formatted(marca)));
        return dateAngajareUnitate;
    }

    public DateAngajareUnitate addAngajatNouDateAngajare(DateAngajareUnitate angajatNou) {
        DateAngajareUnitate completareDateAngajareAngajatNou = DateAngajareUnitate.builder()
                .marca(angajatNou.getMarca())
                .dataAngajariiUnitate(angajatNou.getDataAngajariiUnitate())
                .departament(angajatNou.getDepartament())
                .functie(angajatNou.getFunctie())
                .build();
        return dateAngajareUnitateRepository.save(completareDateAngajareAngajatNou);

    }

    public DateAngajareUnitate updateDateAngajareUnitate(Integer marca, DateAngajareUnitate updateDateAngajare) {
        DateAngajareUnitate foundDateAngajare = getDateAngajareByMarca(marca);
        DateAngajareUnitate updatedAngajare = DateAngajareUnitate.builder()
                .marca(foundDateAngajare.getMarca())
                .dataAngajariiUnitate(updateDateAngajare.getDataAngajariiUnitate())
                .departament(updateDateAngajare.getDepartament())
                .functie(updateDateAngajare.getFunctie())
                .build();
        return dateAngajareUnitateRepository.save(updatedAngajare);
    }

    public DateAngajareUnitate deleteDateAngajareUnitate(Integer marca) {
        DateAngajareUnitate dateAngajareUnitatePtSters = dateAngajareUnitateRepository.findByMarca(marca);
        dateAngajareUnitateRepository.deleteById(marca);
        return dateAngajareUnitatePtSters;
    }

}
