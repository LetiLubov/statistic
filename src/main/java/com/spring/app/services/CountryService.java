package com.spring.app.services;

import com.spring.app.domain.Country;
import com.spring.app.domain.dao.CountryDAO;
import com.spring.app.dto.CountryDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Service for country
 * Save new entry to db
 * Get list of all entries from db
 *
 * @author Lyubov Ruzanova
 */
@Service
public class CountryService {

    private CountryDAO repository;

    /**
     * Inject a country repository
     * @param repository - country repository
     */
    public CountryService(@Autowired CountryDAO repository) {
        this.repository = repository;
    }

    /**
     * Get all countries from repository and convert them to CountryDTO format
     * @return list of countries
     */
    public List<CountryDTO> getList(){
        return repository
                .findAll()
                .stream()
                .map(c -> new CountryDTO().fromEntity(c))
                .collect(Collectors.toList());
    }

    /**
     * Calculate the average salary of a country
     * @param name - country's name
     * @return the double value of the average salary
     */
    public double getMeanSalary(String name){
        return repository.findMeanSalary(name);
    }

    /**
     * Save a new country to DB
     * @param country - the country to save in DB
     */
    public void save(Country country){
        repository.create(country);
    }
}
