package org.fasttrackit.salaryApplication.controller;

import lombok.RequiredArgsConstructor;
import org.fasttrackit.salaryApplication.model.DateSalariale;
import org.fasttrackit.salaryApplication.model.Pontaj;
import org.fasttrackit.salaryApplication.service.PontajService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("aplicatie_salarizare")
public class PontajController {
    private final PontajService service;

    @GetMapping("/pontaj")
    public List<Pontaj> getPontaj() {
        return service.getPontaj();
    }


    @PostMapping("/pontaj")
    public Pontaj addNewEmployeePontaj(@RequestBody Pontaj newEmployee) {
        return service.addPontaj(newEmployee);
    }

    @DeleteMapping("/pontaj/{marca}")
    public Pontaj deletePontaj(@PathVariable Integer marca){
        return service.deletePontaj(marca);
    }

}
