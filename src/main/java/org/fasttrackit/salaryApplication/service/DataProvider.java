package org.fasttrackit.salaryApplication.service;

import java.io.IOException;
import java.util.List;

public interface DataProvider {
    List<?> completeazaDateAngajati() throws IOException;

    List<?> completeazaDateAngajare() throws IOException;

    List<?> completeazaDateSalariale() throws IOException;

    List<?> completeazaPontaj() throws IOException;


}
