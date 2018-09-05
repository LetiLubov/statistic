package com.spring.app.repos;

import com.spring.app.domain.Company;
import com.spring.app.domain.Country;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CompanyRepository extends CrudRepository<Company, Long> {

    List<Company> findByName(String name);
    List<Company> findByCountry(Country country);
    List<Company> findAll();

}
