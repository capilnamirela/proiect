package org.fasttrackit.salaryApplication.controller;

import lombok.RequiredArgsConstructor;
import org.fasttrackit.salaryApplication.model.DateAngajareUnitate;
import org.fasttrackit.salaryApplication.model.DateAngajati;
import org.fasttrackit.salaryApplication.model.DateSalariale;
import org.fasttrackit.salaryApplication.service.DateSalarialeService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("aplicatie_salarizare")
public class DateSalarialeController {
    private final DateSalarialeService service;

    @GetMapping("/date_salariale")
    public List<DateSalariale> getDateSalariale() {
        return service.getDateSalariale();
    }


    @PostMapping("/date_salariale")
    public DateSalariale addNewEmployeeDateSalariale(@RequestBody DateSalariale newEmployee) {
        return service.addAngajatNouDateSalariale(newEmployee);
    }

    @DeleteMapping("/date_salariale/{marca}")
    public DateSalariale deleteDateSalariale(@PathVariable Integer marca){
        return service.deleteDateSalariale(marca);
    }


}
