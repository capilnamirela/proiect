package org.fasttrackit.salaryApplication.service;

import lombok.SneakyThrows;
import org.fasttrackit.salaryApplication.model.DateAngajareUnitate;
import org.fasttrackit.salaryApplication.model.DateAngajati;
import org.fasttrackit.salaryApplication.model.DateSalariale;
import org.fasttrackit.salaryApplication.model.Pontaj;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import static java.lang.Integer.valueOf;

@Component
public class FileReader implements DataProvider {
    @Value("${file.angajati}")
    private String fileAngajatiPath;


    @Value("${file.pontaj}")
    private String filePontajPath;

    @SneakyThrows
    @Override
    public List<DateAngajati> completeazaDateAngajati() {
        List<DateAngajati> dateAngajatiList = Files.lines(Path.of(fileAngajatiPath))
                .map(this::lineToDateAngajati)
                .toList();
        // System.out.println(dateAngajatiList);
        return dateAngajatiList;
    }

    @SneakyThrows
    @Override
    public List<DateAngajareUnitate> completeazaDateAngajare() {
        List<DateAngajareUnitate> dateAngajareUnitateList = Files.lines(Path.of(fileAngajatiPath))
                .map(this::lineToDateAngajareUnitate)
                .toList();
        // System.out.println(dateAngajareUnitateList);
        return dateAngajareUnitateList;
    }

    @SneakyThrows
    @Override
    public List<DateSalariale> completeazaDateSalariale() {
        List<DateSalariale> dateSalarialeList = Files.lines(Path.of(fileAngajatiPath))
                .map(this::lineToDateSalariale)
                .toList();
        //   System.out.println(dateSalarialeList);
        return dateSalarialeList;
    }

    @SneakyThrows
    @Override
    public List<Pontaj> completeazaPontaj() {
        List<Pontaj> pontajList = Files.lines(Path.of(filePontajPath))
                .map(this::lineToPontaj)
                .toList();
        //   System.out.println(pontajList);
        return pontajList;
    }

    private DateAngajati lineToDateAngajati(String line) {
        String[] angajati = line.split("\\|");
        return DateAngajati.builder()
                .marca(valueOf(angajati[0]))
                .nume(angajati[1])
                .prenume(angajati[2])
                .cnp(angajati[3])
                .adresa(angajati[4])
                .build();
    }

    private DateAngajareUnitate lineToDateAngajareUnitate(String line) {
        String[] angajati = line.split("\\|");
        return DateAngajareUnitate.builder()
                .marca(valueOf(angajati[0]))
                .dataAngajariiUnitate(citireDateCaledaristice(angajati[5]))
                .departament(angajati[6])
                .functie(angajati[7])
                .build();
    }

    private static LocalDate citireDateCaledaristice(String data) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
        return LocalDate.parse(data, formatter);
    }

    private DateSalariale lineToDateSalariale(String line) {
        String[] angajati = line.split("\\|");
        return DateSalariale.builder()
                .marca(valueOf(angajati[0]))
                .salariuIncadrare(valueOf(angajati[8]))
                .alteDrepturi(valueOf(angajati[9]))
                .ticheteMasa(valueOf(angajati[10]))
                .build();
    }

    private Pontaj lineToPontaj(String line) {
        String[] angajati = line.split("\\|");
        return Pontaj.builder()
                .marca(valueOf(angajati[0]))
                .zileLucratoare(valueOf(angajati[1]))
                .zileLucrate(valueOf(angajati[2]))
                .zileCO(valueOf(angajati[3]))
                .zileCFS(valueOf(angajati[4]))
                .build();
    }


}
