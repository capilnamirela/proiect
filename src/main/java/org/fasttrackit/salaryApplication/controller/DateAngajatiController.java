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

    @GetMapping("/datePersonale")
    public List<DateAngajati> getAllEmployeesPersonalData() {
        return service.getDateAngajati();
    }

    @PostMapping("/datePersonale")
    public DateAngajati addNewEmployee(@RequestBody DateAngajati newEmployee) {
        return service.addNewEmployee(newEmployee);
    }


}
