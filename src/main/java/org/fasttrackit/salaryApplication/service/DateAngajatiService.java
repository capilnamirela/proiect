package org.fasttrackit.salaryApplication.service;

import lombok.Data;
import org.fasttrackit.salaryApplication.exceptions.ResourceNotFoundException;
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

    public DateAngajati getAngajatByMarca(Integer marca) {
        DateAngajati dateAngajati = dateAngajatiRepository.findById(marca)
                .orElseThrow(() -> new ResourceNotFoundException("Angajatul cu marca: %s nu a fost gasit".formatted(marca)));
        return dateAngajati;
    }


    public DateAngajati addAngajatNou(DateAngajati angajatNou) {
        return dateAngajatiRepository.save(angajatNou);
    }

    public DateAngajati updateDateAngajat(Integer marca, DateAngajati updateDateAngajati) {
        DateAngajati foundAngajat = getAngajatByMarca(marca);
        DateAngajati updatedAngajat = DateAngajati.builder()
                .marca(foundAngajat.getMarca())
                .nume(updateDateAngajati.getNume())
                .prenume(updateDateAngajati.getPrenume())
                .cnp(updateDateAngajati.getCnp())
                .adresa(updateDateAngajati.getAdresa())
                .copiiMinori(updateDateAngajati.getCopiiMinori())
                .build();
        return dateAngajatiRepository.save(updatedAngajat);
    }


    public DateAngajati deleteAngajat(Integer marca) {
        DateAngajati dateAngajatPtSters = dateAngajatiRepository.findByMarca(marca);
        dateAngajatiRepository.deleteById(marca);
        return dateAngajatPtSters;
    }


}
