package org.fasttrackit.salaryApplication.controller;

import lombok.RequiredArgsConstructor;
import org.fasttrackit.salaryApplication.client.model.DateAngajareDTO;
import org.fasttrackit.salaryApplication.client.model.DateAngajareMapper;
import org.fasttrackit.salaryApplication.model.DateAngajareUnitate;
import org.fasttrackit.salaryApplication.service.DateAngajareUnitateService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.fasttrackit.salaryApplication.client.model.DateAngajareMapper.*;

@RestController
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("aplicatie_salarizare")
public class DateAngajareUnitateController {

    private final DateAngajareUnitateService service;


    @GetMapping("/date_angajare_unitate")
    public List<DateAngajareDTO> getDateAngajareUnitate() {
        return service.getDateAngajareUnitate().stream()
                .map(DateAngajareMapper ::toDto )
                .toList();
    }

    @GetMapping("/date_angajare_unitate/{marca}")
    public DateAngajareDTO getDateAngajareByMarca(@PathVariable Integer marca) {
        return toDto(service.getDateAngajareByMarca(marca));
    }
    @PostMapping("/date_angajare_unitate")
    public DateAngajareDTO addNewEmployeeDateAngajare(@RequestBody DateAngajareDTO newEmployee) {
        DateAngajareUnitate dateAngajareUnitateEntity = service.addAngajatNouDateAngajare(toEntity(newEmployee));
        return toDto(dateAngajareUnitateEntity);
    }
    @PutMapping("/date_angajare_unitate/{marca}")
    public DateAngajareDTO updateDateAngajareUnitate(@PathVariable Integer marca, @RequestBody DateAngajareDTO updateDateAngajare) {
        return toDtoUpdate(marca,service.updateDateAngajareUnitate(marca, toEntity(updateDateAngajare)));
    }
    @DeleteMapping("/date_angajare_unitate/{marca}")
    public DateAngajareDTO deleteDateAngajare(@PathVariable Integer marca){
        return toDto(service.deleteDateAngajareUnitate(marca));
    }


}
