package com.spring.app.repos;

import com.spring.app.domain.Country;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * CountryRepository
 * The most common CRUD-requests
 * @author lyubov
 */
public interface CountryRepository extends CrudRepository<Country, Long> {

    List<Country> findByName(String name);

}
