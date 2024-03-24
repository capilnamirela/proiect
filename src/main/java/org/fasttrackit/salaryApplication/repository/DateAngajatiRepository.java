package org.fasttrackit.salaryApplication.repository;

import org.fasttrackit.salaryApplication.model.DateAngajati;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.converter.json.GsonBuilderUtils;
import org.springframework.stereotype.Repository;

@Repository
public interface DateAngajatiRepository extends JpaRepository<DateAngajati, Integer> {
    DateAngajati findByMarca(Integer marca);

}
