package com.spring.app.services;

import com.spring.app.EconomicLevel;
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

    private final CountryDAO repository;

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
     * @param countryName - country's name
     * @return the double value of the average salary
     */
    public Double getMeanSalary(String countryName, Date data1, Date data2) {
        return repository.findMeanSalary(countryName, data1, data2);
    }

    /**
     * Calculate the average employee's experience in the country
     * @param countryName - country's Name
     * @return the Integer value of the average experience
     */
    public Integer getAvgExperience(String countryName, Date date1, Date date2) {
        return repository.findAvgExperience(countryName, date1, date2);
    }

    /**
     * Calculate the average employee's age in the country
     * @param countryName - country's Name
     * @return the Integer value of the average experience
     */
    public Integer getAvgAge(String countryName, Date date1, Date date2) {
        return repository.findAvgAge(countryName, date1, date2);
    }

    /**
     * Calculate the average number of employees in companies in the country
     * @param countryName - country's Name
     * @return the Integer value of the average number of employee
     */
    public Integer getAvgNumberOfEmployeesInCompanies(String countryName, Date date1, Date date2) {
        return repository.findAvgNumberOfEmployeesInCompanies(countryName, date1, date2);
    }

    /**
     * Count number of employees in the country
     * @param countryName - country's Name
     * @return the Long number of employee
     */
    public Long getNumberOfEmployees(String countryName, Date date1, Date date2) {
        return repository.findNumberOfEmployees(countryName, date1, date2);
    }

    /**
     * Count number of vacancies in the country
     * @param countryName - country's Name
     * @return the Long number of vacancies
     */
    public Long getNumberOfVacancies(String countryName, Date date1, Date date2) {
        return repository.findNumberOfVacancies(countryName, date1, date2);
    }

    /**
     * Get the economic level in the country
     * @param countryName - country's Name
     * @return the level of economy
     */
    public EconomicLevel getCountryLevel(String countryName) {
        return repository.getLevelByCountryName(countryName);
    }

    /**
     * Save a new country to DB
     * @param country - the country to save in DB
     */
    public void save(Country country){
        repository.create(country);
    }
}
