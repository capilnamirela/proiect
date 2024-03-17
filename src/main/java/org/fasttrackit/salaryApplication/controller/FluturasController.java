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

    @GetMapping("/fluturas")
        public List<Map<String, Integer>> getFluturasi() {
        return service.getFluturasiSalarizare();
    }

    @GetMapping("/fluturas/{marca}")
    public Map<String, Integer> fluturasSalarizareMarca(@PathVariable Integer marca) {
       return service.fluturasSalarizareMarca(marca);
    }


}
