package org.fasttrackit.salaryApplication.controller;

import lombok.RequiredArgsConstructor;
import org.fasttrackit.salaryApplication.client.mapper.DateAngajatiMapper;
import org.fasttrackit.salaryApplication.client.model.DateAngajatiDTO;
import org.fasttrackit.salaryApplication.model.DateAngajati;
import org.fasttrackit.salaryApplication.service.DateAngajatiService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.fasttrackit.salaryApplication.client.mapper.DateAngajatiMapper.*;

@RestController
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("aplicatie_salarizare")
public class DateAngajatiController {
    private final DateAngajatiService service;

    @GetMapping("/date_personale")
    public List<DateAngajatiDTO> getDatePersonale() {
        return service.getDateAngajati().stream()
                .map(DateAngajatiMapper::toDtoDateAngajati)
                .toList();
    }

    @GetMapping("/date_personale/{marca}")
    public DateAngajatiDTO getDateAngajatiByMarca(@PathVariable Integer marca) {
        return toDtoDateAngajati(service.getAngajatByMarca(marca));
    }

    @PostMapping("/date_personale")
    public DateAngajatiDTO addNewEmployeeDatePersonale(@RequestBody DateAngajatiDTO newEmployee) {
        DateAngajati dateAngajatiEntity = service.addAngajatNou(toEntityDateAngajati(newEmployee));
        return toDtoDateAngajati(dateAngajatiEntity);
    }

    @PutMapping("/date_personale/{marca}")
    public DateAngajatiDTO updateDateAngajati(@PathVariable Integer marca, @RequestBody DateAngajatiDTO dateAngajati) {
        return toDtoUpdateDateAngajati(marca, service.updateDateAngajat(marca, toEntityDateAngajati(dateAngajati)));
    }

    @DeleteMapping("/date_personale/{marca}")
    public DateAngajatiDTO deleteEmployee(@PathVariable Integer marca) {
        return toDtoDateAngajati(service.deleteAngajat(marca));
    }

}
