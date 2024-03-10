package org.fasttrackit.salaryApplication.service;

import lombok.Data;
import org.fasttrackit.salaryApplication.model.DateAngajareUnitate;
import org.fasttrackit.salaryApplication.model.DateAngajati;
import org.fasttrackit.salaryApplication.model.DateSalariale;
import org.fasttrackit.salaryApplication.model.Pontaj;
import org.fasttrackit.salaryApplication.repository.DateAngajatiRepository;
import org.fasttrackit.salaryApplication.repository.PontajRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Data
public class PontajService {

    private DateAngajatiRepository dateAngajatiRepository;
    private final PontajRepository pontajRepository;

    public PontajService(PontajRepository pontajRepository) {
        this.pontajRepository = pontajRepository;
    }

    public List<Pontaj> getPontaj() {
        return pontajRepository.findAll();
    }

    public Pontaj getPontajByMarca(Integer marca) {
        return pontajRepository.findByMarca(marca);
    }


    public Pontaj addPontaj(Pontaj pontajAngajat) {
       Pontaj completarePontaj = Pontaj.builder()
                .marca(pontajAngajat.getMarca())
                .zileLucratoare(pontajAngajat.getZileLucratoare())
                .zileLucrate(pontajAngajat.getZileLucrate())
                .zileCO(pontajAngajat.getZileCO())
                .zileCFS(pontajAngajat.getZileCFS())
                .build();
        return pontajRepository.save(completarePontaj);

    }

    public Pontaj deletePontaj(Integer marca){
        Pontaj pontajPtSters = pontajRepository.findByMarca(marca);
        pontajRepository.deleteById(marca);
        return pontajPtSters;
    }
}
