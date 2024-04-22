package org.fasttrackit.salaryApplication.service;

import lombok.Data;
import org.fasttrackit.salaryApplication.model.DateSalariale;
import org.fasttrackit.salaryApplication.repository.DateAngajatiRepository;
import org.fasttrackit.salaryApplication.repository.DateSalarialeRepository;
import org.fasttrackit.salaryApplication.repository.PontajRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static java.lang.String.valueOf;

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

    public Map<String, String> fluturasSalarizareMarca(Integer marca) {
        Map<String, String> fluturas = new HashMap<>();
        fluturas.put("Marca", valueOf(dateAngajatiRepository.findByMarca(marca).getMarca()));
        fluturas.put("Nume si prenume", dateAngajatiRepository.findByMarca(marca).getNume() + " " + dateAngajatiRepository.findByMarca(marca).getPrenume());
        fluturas.put("Zile lucratoare luna", valueOf(pontajRepository.findByMarca(marca).getZileLucratoare()));
        fluturas.put("Zile lucrate", valueOf(pontajRepository.findByMarca(marca).getZileLucrate()));
        fluturas.put("Zile CO", valueOf(pontajRepository.findByMarca(marca).getZileCO()));
        fluturas.put("Zile CFS", valueOf(pontajRepository.findByMarca(marca).getZileCFS()));
        fluturas.put("Indemnizatie CO", valueOf(salariuCO(marca)));
        fluturas.put("Salariu zile lucrate", valueOf(salariuZileLucrate(marca)));
        fluturas.put("Alte Drepturi", String.valueOf(salariuAlteDrepturi(marca)));
        fluturas.put("Tichete masa", String.valueOf(ticheteMasa(marca)));
        fluturas.put("Venit brut", String.valueOf(venitBrut(marca)));
        fluturas.put("Contributie CAS", String.valueOf(calculCAS(marca)));
        fluturas.put("Contributie sanatate", String.valueOf(calculCASS(marca)));
        fluturas.put("Nr. persoane in intretinere", String.valueOf(dateAngajatiRepository.findByMarca(marca).getCopiiMinori()));
        fluturas.put("Deducere impozit", String.valueOf(deducereImpozit(marca)));
        fluturas.put("Impozit", String.valueOf(calculImpozit(marca)));
        fluturas.put("Venit net", String.valueOf(venitNet(marca)));
        return fluturas;
    }

    public List<Map<String, String>> getFluturasiSalarizare() {
        List<Map<String, String>> fluturasi = new ArrayList<>();

        for (DateSalariale dateSalariale : dateSalarialeRepository.findAll()) {
            if (dateSalariale != null && pontajRepository.existsById(dateSalariale.getMarca())) {
                Map<String, String> fluturas = fluturasSalarizareMarca(dateSalariale.getMarca());
                fluturasi.add(fluturas);
            }
        }
        return fluturasi;
    }

    public String numePrenume(Integer marca) {
        return dateAngajatiRepository.findByMarca(marca).getNume() + " " + dateAngajatiRepository.findByMarca(marca).getPrenume();
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

    public Integer venitBrut(Integer marca) {
        return (salariuCO(marca) + salariuZileLucrate(marca) + salariuAlteDrepturi(marca) + ticheteMasa(marca));
    }

    private int bazaVenitPtCalculCASCASS(Integer marca) {
        return salariuCO(marca) + salariuZileLucrate(marca) + salariuAlteDrepturi(marca);
    }

    public Integer calculCAS(Integer marca) {
        return (int) (bazaVenitPtCalculCASCASS(marca) * PROCENT_CAS);
    }

    public Integer calculCASS(Integer marca) {
        return (int) (bazaVenitPtCalculCASCASS(marca) * PROCENT_CASS);
    }

    public int deducereImpozit(Integer marca) {
        Double deducereBaza = 0.00;
        Integer deducereSuplimentara;

        if ((dateAngajatiRepository.findByMarca(marca).getCopiiMinori() == 0) && ((venitBrut(marca) - CalculDeducereBaza.SALARIU_MINIM) < 2000)) {
            deducereBaza = (CalculDeducereBaza.procentDeducereFaraPersIntretinere(venitBrut(marca)) * CalculDeducereBaza.SALARIU_MINIM) / 100;
        }
        if ((dateAngajatiRepository.findByMarca(marca).getCopiiMinori() == 1) && ((venitBrut(marca) - CalculDeducereBaza.SALARIU_MINIM) < 2000)) {
            deducereBaza = ((CalculDeducereBaza.procentDeducereFaraPersIntretinere(venitBrut(marca)) + 5) * CalculDeducereBaza.SALARIU_MINIM) / 100;
        }
        if ((dateAngajatiRepository.findByMarca(marca).getCopiiMinori() == 2) && ((venitBrut(marca) - CalculDeducereBaza.SALARIU_MINIM) < 2000)) {
            deducereBaza = ((CalculDeducereBaza.procentDeducereFaraPersIntretinere(venitBrut(marca)) + 10) * CalculDeducereBaza.SALARIU_MINIM) / 100;
        }
        if ((dateAngajatiRepository.findByMarca(marca).getCopiiMinori() == 3) && ((venitBrut(marca) - CalculDeducereBaza.SALARIU_MINIM) < 2000)) {
            deducereBaza = ((CalculDeducereBaza.procentDeducereFaraPersIntretinere(venitBrut(marca)) + 15) * CalculDeducereBaza.SALARIU_MINIM) / 100;
        }
        if ((dateAngajatiRepository.findByMarca(marca).getCopiiMinori() >= 4) && ((venitBrut(marca) - CalculDeducereBaza.SALARIU_MINIM) < 2000)) {
            deducereBaza = ((CalculDeducereBaza.procentDeducereFaraPersIntretinere(venitBrut(marca)) + 25) * CalculDeducereBaza.SALARIU_MINIM) / 100;
        }

        deducereSuplimentara = dateAngajatiRepository.findByMarca(marca).getCopiiMinori() * 100;

        return (int) (deducereBaza + deducereSuplimentara);
    }


    private int bazaVenitPtCalculImpozit(Integer marca) {
        return salariuCO(marca) +
                salariuZileLucrate(marca) +
                salariuAlteDrepturi(marca) +
                ticheteMasa(marca) -
                calculCAS(marca) -
                calculCASS(marca) -
                deducereImpozit(marca);
    }

    public Integer calculImpozit(Integer marca) {
        return (int) (bazaVenitPtCalculImpozit(marca) * PROCENT_IMPOZIT);
    }

    public Integer venitNet(Integer marca) {
        return bazaVenitPtCalculImpozit(marca) - calculImpozit(marca) + deducereImpozit(marca);
    }


}
