package org.fasttrackit.salaryApplication.service;

import lombok.Data;
import org.fasttrackit.salaryApplication.model.DateAngajati;
import org.fasttrackit.salaryApplication.repository.DateAngajatiRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Data
public class DateAngajatiService {

    private final DateAngajatiRepository dateAngajatiRepository;

    public DateAngajatiService(DateAngajatiRepository dateAngajatiRepository) {
        this.dateAngajatiRepository = dateAngajatiRepository;
    }

    public List<DateAngajati> getDateAngajati() {
        return dateAngajatiRepository.findAll();
    }
    public DateAngajati getAngajatByMarca(Integer marca){
        return dateAngajatiRepository.findByMarca(marca);
    }


    public DateAngajati addAngajatNou(DateAngajati angajatNou) {
        return dateAngajatiRepository.save(angajatNou);
    }

    public DateAngajati deleteAngajat(Integer marca){
        DateAngajati dateAngajatPtSters = dateAngajatiRepository.findByMarca(marca);
        dateAngajatiRepository.deleteById(marca);
        return dateAngajatPtSters;
    }


}
