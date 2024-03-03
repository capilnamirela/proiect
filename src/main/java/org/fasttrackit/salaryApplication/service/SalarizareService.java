package org.fasttrackit.salaryApplication.service;

import lombok.Data;
import org.fasttrackit.salaryApplication.model.DateAngajareUnitate;
import org.fasttrackit.salaryApplication.model.DateAngajati;
import org.fasttrackit.salaryApplication.model.DateSalariale;
import org.fasttrackit.salaryApplication.model.Pontaj;
import org.fasttrackit.salaryApplication.repository.DateAngajareUnitateRepository;
import org.fasttrackit.salaryApplication.repository.DateAngajatiRepository;
import org.fasttrackit.salaryApplication.repository.DateSalarialeRepository;
import org.fasttrackit.salaryApplication.repository.PontajRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Data
public class SalarizareService {

    private final DateAngajatiRepository dateAngajatiRepository;
    private final DateAngajareUnitateRepository dateAngajareUnitateRepository;
    private final DateSalarialeRepository dateSalarialeRepository;
    private final PontajRepository pontajRepository;

    public SalarizareService(DateAngajatiRepository dateAngajatiRepository,
                             DateAngajareUnitateRepository dateAngajareUnitateRepository,
                             DateSalarialeRepository dateSalarialeRepository,
                             PontajRepository pontajRepository) {
        this.dateAngajatiRepository = dateAngajatiRepository;
        this.dateAngajareUnitateRepository = dateAngajareUnitateRepository;
        this.dateSalarialeRepository = dateSalarialeRepository;
        this.pontajRepository = pontajRepository;
    }


    public List<DateAngajati> getDateAngajati() {
        return dateAngajatiRepository.findAll();

    }

    public List<DateAngajareUnitate> getDateAngajareUnitate() {
        return dateAngajareUnitateRepository.findAll();
    }

    public List<DateSalariale> getDateSalariale() {
        return dateSalarialeRepository.findAll();
    }

    public List<Pontaj> getPontaj() {
        return pontajRepository.findAll();
    }

    public DateAngajati addNewEmployee(DateAngajati newEmployee) {
        return dateAngajatiRepository.save(newEmployee);

    }

    public DateAngajareUnitate addNewEmployeeDateAngajare(Integer marca, DateAngajareUnitate newEmployee) {
        DateAngajati angajatNou = dateAngajatiRepository.findByMarca(marca);
        DateAngajareUnitate completareDateAngajareAngajatNou = DateAngajareUnitate.builder()
                .marca(angajatNou.getMarca())
                .dataAngajariiUnitate(newEmployee.getDataAngajariiUnitate())
                .departament(newEmployee.getDepartament())
                .functie(newEmployee.getFunctie())
                .build();
        return dateAngajareUnitateRepository.save(completareDateAngajareAngajatNou);

    }

    public DateSalariale addNewEmployeeDateSalariale(Integer marca, DateSalariale newEmployee) {
        DateAngajati angajatNou = dateAngajatiRepository.findByMarca(marca);
        DateSalariale completareDateSalarizareAngajatNou = DateSalariale.builder()
                .marca(angajatNou.getMarca())
                .salariuIncadrare(newEmployee.getSalariuIncadrare())
                .alteDrepturi(newEmployee.getAlteDrepturi())
                .ticheteMasa(newEmployee.getTicheteMasa())
                .build();
        return dateSalarialeRepository.save(completareDateSalarizareAngajatNou);
    }

    public Pontaj addNewEmployeePontaj(Integer marca, Pontaj newEmployee) {
        DateAngajati angajatNou = dateAngajatiRepository.findByMarca(marca);
        Pontaj completarePontajAngajatNou = Pontaj.builder()
                .marca(angajatNou.getMarca())
                .zileLucratoare(newEmployee.getZileLucratoare())
                .zileLucrate(newEmployee.getZileLucrate())
                .zileCO(newEmployee.getZileCO())
                .zileCFS(newEmployee.getZileCFS())
                .build();
        return pontajRepository.save(completarePontajAngajatNou);

    }
}
