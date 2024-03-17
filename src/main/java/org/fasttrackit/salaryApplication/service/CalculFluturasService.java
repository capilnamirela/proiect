package org.fasttrackit.salaryApplication.service;

import lombok.Data;
import org.fasttrackit.salaryApplication.model.DateAngajati;
import org.fasttrackit.salaryApplication.model.DateSalariale;
import org.fasttrackit.salaryApplication.repository.DateAngajatiRepository;
import org.fasttrackit.salaryApplication.repository.DateSalarialeRepository;
import org.fasttrackit.salaryApplication.repository.PontajRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@Data
public class CalculFluturasService {
    public static final double PROCENT_CAS = 0.25;
    public static final double PROCENT_CASS = 0.10;
    public static final double PROCENT_IMPOZIT = 0.10;
    private DateSalarialeRepository dateSalarialeRepository;
    private PontajRepository pontajRepository;
    private DateAngajatiRepository dateAngajatiRepository;


    public CalculFluturasService(DateAngajatiRepository dateAngajatiRepository,
                                 DateSalarialeRepository dateSalarialeRepository,
                                 PontajRepository pontajRepository) {
        this.dateAngajatiRepository = dateAngajatiRepository;
        this.dateSalarialeRepository = dateSalarialeRepository;
        this.pontajRepository = pontajRepository;
    }

    public Map<String, Integer> fluturasSalarizareMarca(Integer marca) {
        Map<String, Integer> fluturas = new HashMap<>();
        fluturas.put("Marca", dateAngajatiRepository.findByMarca(marca).getMarca());
        fluturas.put("Zile lucratoare luna", pontajRepository.findByMarca(marca).getZileLucratoare());
        fluturas.put("Zile lucrate", pontajRepository.findByMarca(marca).getZileLucrate());
        fluturas.put("Zile CO", pontajRepository.findByMarca(marca).getZileCO());
        fluturas.put("Zile CFS", pontajRepository.findByMarca(marca).getZileCFS());
        fluturas.put("Indemnizatie CO", salariuCO(marca));
        fluturas.put("Salariu zile lucrate", salariuZileLucrate(marca));
        fluturas.put("Alte Drepturi", salariuAlteDrepturi(marca));
        fluturas.put("Tichete masa", ticheteMasa(marca));
        fluturas.put("Venit brut", salariuCO(marca) + salariuZileLucrate(marca) + salariuAlteDrepturi(marca) + ticheteMasa(marca));
        fluturas.put("Contributie CAS", calculCAS(marca));
        fluturas.put("Contributie sanatate", calculCASS(marca));
        fluturas.put("Impozit", calculImpozit(marca));
        fluturas.put("Venit net", venitNet(marca));
        return fluturas;
    }

    public List<Map<String, Integer>> getFluturasiSalarizare() {
        List<Map<String, Integer>> fluturasi = new ArrayList<>();

        for (DateSalariale dateSalariale : dateSalarialeRepository.findAll()) {
            Map<String, Integer> fluturas = fluturasSalarizareMarca(dateSalariale.getMarca());
            fluturasi.add(fluturas);
        }
        return fluturasi;
    }



    public Integer salariuCO(Integer marca) {
        Integer salariuIncadrare = dateSalarialeRepository.findByMarca(marca).getSalariuIncadrare();
        Integer alteDrepturi = dateSalarialeRepository.findByMarca(marca).getAlteDrepturi();
        Integer zileLucratoare = pontajRepository.findByMarca(marca).getZileLucratoare();
        Integer zileCO = pontajRepository.findByMarca(marca).getZileCO();
        return (salariuIncadrare + alteDrepturi) * zileCO / zileLucratoare;
    }

    public Integer salariuZileLucrate(Integer marca) {
        Integer salariuIncadrare = dateSalarialeRepository.findByMarca(marca).getSalariuIncadrare();
        Integer zileLucratoare = pontajRepository.findByMarca(marca).getZileLucratoare();
        Integer zileLucrate = pontajRepository.findByMarca(marca).getZileLucrate();
        return (salariuIncadrare * zileLucrate) / zileLucratoare;
    }

    public Integer salariuAlteDrepturi(Integer marca) {
        Integer alteDrepturi = dateSalarialeRepository.findByMarca(marca).getAlteDrepturi();
        Integer zileLucratoare = pontajRepository.findByMarca(marca).getZileLucratoare();
        Integer zileLucrate = pontajRepository.findByMarca(marca).getZileLucrate();
        return (alteDrepturi * zileLucrate) / zileLucratoare;
    }

    public Integer ticheteMasa(Integer marca) {
        Integer zileLucrate = pontajRepository.findByMarca(marca).getZileLucrate();
        Integer ticheteMasaPeZiLucrata = dateSalarialeRepository.findByMarca(marca).getTicheteMasa();
        return (ticheteMasaPeZiLucrata * zileLucrate);
    }

    private int getBazaVenitPtCalculCASCASS(Integer marca) {
        return salariuCO(marca) + salariuZileLucrate(marca) + salariuAlteDrepturi(marca);
    }

    public Integer calculCAS(Integer marca) {
        return (int) (getBazaVenitPtCalculCASCASS(marca) * PROCENT_CAS);
    }

    public Integer calculCASS(Integer marca) {
        return (int) (getBazaVenitPtCalculCASCASS(marca) * PROCENT_CASS);
    }

    private int getBazaVenitPtCalculImpozit(Integer marca) {
        return salariuCO(marca) +
                salariuZileLucrate(marca) +
                salariuAlteDrepturi(marca) +
                ticheteMasa(marca) -
                calculCAS(marca) -
                calculCASS(marca);
    }

    public Integer calculImpozit(Integer marca) {
        return (int) (getBazaVenitPtCalculImpozit(marca) * PROCENT_IMPOZIT);
    }

    public Integer venitNet(Integer marca) {
        return getBazaVenitPtCalculImpozit(marca) - calculImpozit(marca);
    }


}
