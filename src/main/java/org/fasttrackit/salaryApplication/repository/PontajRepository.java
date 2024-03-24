package org.fasttrackit.salaryApplication.repository;

import org.fasttrackit.salaryApplication.model.Pontaj;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PontajRepository extends JpaRepository<Pontaj, Integer> {
    Pontaj findByMarca(Integer marca);
}
