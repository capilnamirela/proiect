package org.fasttrackit.salaryApplication.repository;

import org.fasttrackit.salaryApplication.model.DateAngajareUnitate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DateAngajareUnitateRepository extends JpaRepository<DateAngajareUnitate, Integer> {
    DateAngajareUnitate findByMarca(Integer marca);
}
