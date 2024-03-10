package org.fasttrackit.salaryApplication.controller;

import lombok.RequiredArgsConstructor;
import org.fasttrackit.salaryApplication.service.CalculFluturasService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequiredArgsConstructor
@RequestMapping("aplicatie_salarizare")
public class RapoarteController {
    private final CalculFluturasService service;

     /*   @GetMapping("/fluturas")
        public List<DateAngajati> getAllEmployeesPersonalData() {
            return service.getDateAngajati();}*/


    @GetMapping("/fluturas/{marca}")
    public Map<String, Integer> fluturasSalarizareMarca(@PathVariable Integer marca) {
       return service.fluturasSalarizareMarca(marca);
    }


}
