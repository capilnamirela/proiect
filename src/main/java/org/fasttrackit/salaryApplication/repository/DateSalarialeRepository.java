package org.fasttrackit.salaryApplication.repository;

import org.fasttrackit.salaryApplication.model.DateAngajati;
import org.fasttrackit.salaryApplication.model.DateSalariale;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DateSalarialeRepository extends JpaRepository<DateSalariale, Integer> {
    DateSalariale findByMarca(Integer marca);
}
