package org.fasttrackit.salaryApplication.controller;

import lombok.RequiredArgsConstructor;
import org.fasttrackit.salaryApplication.model.DateAngajareUnitate;
import org.fasttrackit.salaryApplication.model.DateAngajati;
import org.fasttrackit.salaryApplication.model.DateSalariale;
import org.fasttrackit.salaryApplication.model.Pontaj;
import org.fasttrackit.salaryApplication.service.SalarizareService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("angajati")
public class SalarizareController {
    private final SalarizareService service;

    @GetMapping("/datePersonale")
    public List<DateAngajati> getAllEmployeesPersonalData() {
        return service.getDateAngajati();
    }

    @GetMapping("/dateAngajareUnitate")
    public List<DateAngajareUnitate> getDateAngajareUnitate(){
        return service.getDateAngajareUnitate();
    }

    @GetMapping("/dateSalariale")
    public List<DateSalariale> getDateSalariale(){
        return service.getDateSalariale();
    }

    @GetMapping("/pontaj")
    public List<Pontaj> getPontaj(){
        return service.getPontaj();
    }

    @PostMapping("/datePersonale")
    public DateAngajati addNewEmployee(@RequestBody DateAngajati newEmployee){
        return service.addNewEmployee(newEmployee);
    }

    @PostMapping("/dateAngajareUnitate/{marca}")
    public DateAngajareUnitate addNewEmployeeDateAngajare(@PathVariable Integer marca, @RequestBody DateAngajareUnitate newEmployee){
        return service.addNewEmployeeDateAngajare(marca, newEmployee);
    }
    @PostMapping("/dateSalariale/{marca}")
    public DateSalariale addNewEmployeeDateSalariale(@PathVariable Integer marca, @RequestBody DateSalariale newEmployee){
        return service.addNewEmployeeDateSalariale(marca, newEmployee);
    }

    @PostMapping("/pontaj/{marca}")
    public Pontaj addNewEmployeePontaj(@PathVariable Integer marca, @RequestBody Pontaj newEmployee){
        return service.addNewEmployeePontaj(marca, newEmployee);
    }

}
