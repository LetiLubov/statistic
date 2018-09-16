package com.spring.app.services;

import com.spring.app.domain.Country;
import com.spring.app.domain.dao.CountryDAO;
import com.spring.app.dto.CountryDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Service for country
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
     * Calculate the average salary of employees in the country
     * @param name - country's name
     * @return the double value of the average salary
     */
    public Double getMeanSalary(String name, Date data1, Date data2){
        return repository.findMeanSalary(name, data1, data2);
    }

    /**
     * Calculate the average employee's experience in the country
     * @param name - country's name
     * @return the Integer value of the average experience
     */
    public Integer getAvgExperience(String name, Date date1, Date date2){
        return repository.findAvgExperience(name, date1, date2);
    }

    /**
     * Calculate the average employee's age in the country
     * @param name - country's name
     * @return the Integer value of the average experience
     */
    public Integer getAvgAge(String name, Date date1, Date date2){
        return repository.findAvgAge(name, date1, date2);
    }

    /**
     * Calculate the average number of employees in companies in the country
     * @param name - country's name
     * @return the Integer value of the average number of employee
     */
    public Integer getAvgNumberOfEmployees(String name, Date date1, Date date2){
        return repository.findAvgNumberOfEmployees(name, date1, date2);
    }

    /**
     * Save a new country to DB
     * @param country - the country to save in DB
     */
    public void save(Country country){
        repository.create(country);
    }
}
