package org.fasttrackit.salaryApplication.controller;

import lombok.RequiredArgsConstructor;
import org.fasttrackit.salaryApplication.client.mapper.DateSalarialeMapper;
import org.fasttrackit.salaryApplication.client.model.DateSalarialeDTO;
import org.fasttrackit.salaryApplication.model.DateSalariale;
import org.fasttrackit.salaryApplication.service.DateSalarialeService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.fasttrackit.salaryApplication.client.mapper.DateSalarialeMapper.*;

@RestController
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("aplicatie_salarizare")
public class DateSalarialeController {
    private final DateSalarialeService service;

    @GetMapping("/date_salariale")
    public List<DateSalarialeDTO> getDateSalariale() {
        return service.getDateSalariale().stream()
                .map(DateSalarialeMapper::toDtoDateSalariale)
                .toList();
    }

    @GetMapping("/date_salariale/{marca}")
    public DateSalarialeDTO getDateSalarialeByMarca(@PathVariable Integer marca) {
        return toDtoDateSalariale(service.getDateSalarialeByMarca(marca));
    }

    @PostMapping("/date_salariale")
    public DateSalarialeDTO addNewEmployeeDateSalariale(@RequestBody DateSalarialeDTO newEmployee) {
        DateSalariale dateSalarialeEntity = service.addAngajatNouDateSalariale(toEntityDateSalariale(newEmployee));
        return toDtoDateSalariale(dateSalarialeEntity);
    }

    @PutMapping("/date_salariale/{marca}")
    public DateSalarialeDTO updateDateSalariale(@PathVariable Integer marca, @RequestBody DateSalarialeDTO dateSalarialeDTO) {
        return toDtoUpdateDateSalariale(marca, service.updateDateSalariale(marca, toEntityDateSalariale(dateSalarialeDTO)));
    }

    @DeleteMapping("/date_salariale/{marca}")
    public DateSalarialeDTO deleteDateSalariale(@PathVariable Integer marca) {
        return toDtoDateSalariale(service.deleteDateSalariale(marca));
    }


}
