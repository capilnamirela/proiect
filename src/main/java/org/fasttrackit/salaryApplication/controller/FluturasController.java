package org.fasttrackit.salaryApplication.controller;

import lombok.RequiredArgsConstructor;
import org.fasttrackit.salaryApplication.service.CalculFluturasService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequiredArgsConstructor
@RequestMapping("aplicatie_salarizare/date_salariale")
public class FluturasController {
    private final CalculFluturasService service;

    @GetMapping("/fluturasi")
    public List<Map<String, String>> getFluturasi() {
        return service.getFluturasiSalarizare();
    }

    @GetMapping("/fluturasi/{marca}")
    public Map<String, String> fluturasSalarizareMarca(@PathVariable Integer marca) {
        return service.fluturasSalarizareMarca(marca);
    }


}
