package org.fasttrackit.salaryApplication.controller;

import lombok.RequiredArgsConstructor;
import org.fasttrackit.salaryApplication.model.DateAngajareUnitate;
import org.fasttrackit.salaryApplication.model.DateAngajati;
import org.fasttrackit.salaryApplication.service.DateAngajareUnitateService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("aplicatie_salarizare")
public class DateAngajareUnitateController {
    private final DateAngajareUnitateService service;


    @GetMapping("/date_angajare_unitate")
    public List<DateAngajareUnitate> getDateAngajareUnitate() {
        return service.getDateAngajareUnitate();
    }
    @GetMapping("/date_angajare_unitate/{marca}")
    public DateAngajareUnitate getDateAngajareByMarca(@PathVariable Integer marca) {
        return service.getDateAngajatiByMarca(marca);
    }
    @PostMapping("/date_angajare_unitate")
    public DateAngajareUnitate addNewEmployeeDateAngajare(@RequestBody DateAngajareUnitate newEmployee) {
        return service.addAngajatNouDateAngajare(newEmployee);
    }

    @DeleteMapping("/date_angajare_unitate/{marca}")
    public DateAngajareUnitate deleteDateAngajare(@PathVariable Integer marca){
        return service.deleteDateAngajareUnitate(marca);
    }


}
