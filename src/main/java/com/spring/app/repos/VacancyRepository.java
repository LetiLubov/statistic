package com.spring.app.repos;

import com.spring.app.domain.Company;
import com.spring.app.domain.Vacancy;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * VacancyRepository
 * The most common CRUD-requests
 * @author lyubov
 */
public interface VacancyRepository extends CrudRepository<Vacancy, Long> {
    List<Vacancy> findByName(String name);
    List<Vacancy> findByCompany(Company company);

}