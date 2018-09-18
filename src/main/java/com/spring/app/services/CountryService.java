package com.spring.app.services;

import com.spring.app.domain.Country;
import com.spring.app.domain.dao.CountryDAO;
import com.spring.app.dto.CountryDTO;
import com.spring.app.dto.CountryProfileDTO;
import com.spring.app.dto.EmployeeProfileDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Map;
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
     * @param date1       - start date of the period
     * @param date2       - end date of the period
     * @return the double value of the average salary
     */
    public Double getMeanSalary(String countryName, Date date1, Date date2) {
        return repository.findMeanSalary(countryName, date1, date2);
    }

    /**
     * Calculate the average employee's experience in the country
     * @param countryName - country's Name
     * @param date1       - start date of the period
     * @param date2       - end date of the period
     * @return the Integer value of the average experience
     */
    public Integer getAvgExperience(String countryName, Date date1, Date date2) {
        return repository.findAvgExperience(countryName, date1, date2);
    }

    /**
     * Calculate the average employee's age in the country
     * @param countryName - country's Name
     * @param date1       - start date of the period
     * @param date2       - end date of the period
     * @return the Integer value of the average experience
     */
    public Integer getAvgAge(String countryName, Date date1, Date date2) {
        return repository.findAvgAge(countryName, date1, date2);
    }

    /**
     * Calculate the average number of employees in companies in the country
     * @param countryName - country's Name
     * @param date1       - start date of the period
     * @param date2       - end date of the period
     * @return the Integer value of the average number of employee
     */
    public Integer getAvgNumberOfEmployeesInCompanies(String countryName, Date date1, Date date2) {
        return repository.findAvgNumberOfEmployeesInCompanies(countryName, date1, date2);
    }


    /**
     * Find out employee profiles for all countries
     * @param date1       - start date of the period
     * @param date2       - end date of the period
     * @return map of employee profiles (as a value) and countries name (as a key)
     */
    public Map<String, EmployeeProfileDTO> getEmployeeProfiles(Date date1, Date date2) {
        return repository.getEmployeeProfiles(date1, date2);
    }

    /**
     * Find out profiles for all countries
     * @param date1       - start date of the period
     * @param date2       - end date of the period
     * @return map of country profiles (as a value) and countries name (as a key)
     */
    public Map<String, CountryProfileDTO> getProfiles(Date date1, Date date2) {
        return repository.getProfiles(date1, date2);
    }

    /**
     * Save a new country to DB
     * @param country - the country to save in DB
     */
    public void save(Country country){
        repository.create(country);
    }
}
