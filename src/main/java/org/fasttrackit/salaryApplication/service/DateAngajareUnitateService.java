package org.fasttrackit.salaryApplication.service;

import lombok.Data;
import org.fasttrackit.salaryApplication.model.DateAngajareUnitate;
import org.fasttrackit.salaryApplication.model.DateAngajati;
import org.fasttrackit.salaryApplication.repository.DateAngajareUnitateRepository;
import org.fasttrackit.salaryApplication.repository.DateAngajatiRepository;
import org.springframework.beans.factory.annotation.Autowired;
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

    public DateAngajareUnitate getDateAngajatiByMarca(Integer marca) {
        return dateAngajareUnitateRepository.findByMarca(marca);
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

    public DateAngajareUnitate deleteDateAngajareUnitate(Integer marca) {
        DateAngajareUnitate dateAngajareUnitatePtSters = dateAngajareUnitateRepository.findByMarca(marca);
        dateAngajareUnitateRepository.deleteById(marca);
        return dateAngajareUnitatePtSters;
    }

}

