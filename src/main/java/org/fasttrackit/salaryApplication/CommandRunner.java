package org.fasttrackit.salaryApplication;

import lombok.RequiredArgsConstructor;
import org.fasttrackit.salaryApplication.repository.DateAngajareUnitateRepository;
import org.fasttrackit.salaryApplication.repository.DateAngajatiRepository;
import org.fasttrackit.salaryApplication.repository.DateSalarialeRepository;
import org.fasttrackit.salaryApplication.repository.PontajRepository;
import org.fasttrackit.salaryApplication.service.FileReader;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
@RequiredArgsConstructor
public class CommandRunner implements CommandLineRunner {

    private final DateAngajatiRepository dateAngajatiRepository;
    private final DateAngajareUnitateRepository dateAngajareUnitateRepository;
    private final DateSalarialeRepository dateSalarialeRepository;
    private final PontajRepository pontajRepository;
    private final FileReader fileReader;

    @Override
    public void run(String... args) {
        this.dateAngajatiRepository.saveAll(fileReader.completeazaDateAngajati());
        this.dateAngajareUnitateRepository.saveAll(fileReader.completeazaDateAngajare());
        this.dateSalarialeRepository.saveAll(fileReader.completeazaDateSalariale());
        this.pontajRepository.saveAll(fileReader.completeazaPontaj());
    }
}
