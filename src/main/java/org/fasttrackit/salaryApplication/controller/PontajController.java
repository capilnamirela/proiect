package org.fasttrackit.salaryApplication.controller;

import lombok.RequiredArgsConstructor;
import org.fasttrackit.salaryApplication.client.mapper.PontajMapper;
import org.fasttrackit.salaryApplication.client.model.PontajDTO;
import org.fasttrackit.salaryApplication.model.Pontaj;
import org.fasttrackit.salaryApplication.service.PontajService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.fasttrackit.salaryApplication.client.mapper.PontajMapper.*;

@RestController
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("aplicatie_salarizare")
public class PontajController {
    private final PontajService service;

    @GetMapping("/pontaj")
    public List<PontajDTO> getPontaj() {
        return service.getPontaj().stream()
                .map(PontajMapper::toDtoPontaj)
                .toList();
    }

    @GetMapping("/pontaj/{marca}")
    public PontajDTO getPontajByMarca(@PathVariable Integer marca) {
        return toDtoPontaj(service.getPontajByMarca(marca));
    }

    @PostMapping("/pontaj")
    public PontajDTO addNewEmployeePontaj(@RequestBody PontajDTO newEmployee) {
        Pontaj pontajEntity = service.addPontaj(toEntityPontaj(newEmployee));
        return toDtoPontaj(pontajEntity);
    }

    @PutMapping("/pontaj/{marca}")
    public PontajDTO updatePontaj(@PathVariable Integer marca, @RequestBody PontajDTO pontajDTO) {
        return toDtoUpdatePontaj(marca, service.updatePontaj(marca, toEntityPontaj(pontajDTO)));
    }

    @DeleteMapping("/pontaj/{marca}")
    public PontajDTO deletePontaj(@PathVariable Integer marca) {
        return toDtoPontaj(service.deletePontaj(marca));
    }

}
