package org.fasttrackit.salaryApplication.controller;

import lombok.RequiredArgsConstructor;
import org.fasttrackit.salaryApplication.model.DateAngajati;
import org.fasttrackit.salaryApplication.service.DateAngajatiService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("aplicatie_salarizare")
public class DateAngajatiController {
    private final DateAngajatiService service;

    @GetMapping("/date_personale")
    public List<DateAngajati> getAllEmployeesPersonalData() {
        return service.getDateAngajati();
    }

    @GetMapping("/date_personale/{marca}")
    public DateAngajati getAngajatByMarca(@PathVariable Integer marca) {
        return service.getAngajatByMarca(marca);
    }

    @PostMapping("/date_personale")
    public DateAngajati addNewEmployee(@RequestBody DateAngajati newEmployee) {
        return service.addAngajatNou(newEmployee);
    }

    @DeleteMapping("/date_personale/{marca}")
    public DateAngajati deleteEmployee(@PathVariable Integer marca) {
        return service.deleteAngajat(marca);
    }

}
