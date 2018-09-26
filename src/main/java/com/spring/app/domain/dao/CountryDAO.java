package com.spring.app.domain.dao;

import com.spring.app.domain.Country;
import com.spring.app.dto.CountryProfileDTO;
import com.spring.app.dto.EmployeeProfileDTO;
import com.spring.app.services.mappers.CountryProfileDTOResultMapper;
import com.spring.app.services.mappers.EmployeeProfileDTOResultMapper;
import com.spring.app.services.mappers.ResultMapper;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * DAO for Country
 * Has default features {@inheritDoc}
 * And special queries to DB
 *
 * @author Lyubov Ruzanova
 */
@Repository
public class CountryDAO extends GenericDaoImpl<Country> {

    /**
     * Creates query to DB to find the average salary of the country in period of time
     *
     * @param date1       - start date of the period
     * @param date2       - end date of the period
     * @param countryName - country's name
     * @return the double value of the average salary
     */
    public double findMeanSalary(String countryName, Date date1, Date date2) {
        return ResultMapper.getDouble(em.createNamedQuery(Country.MEAN_SALARY)
                .setParameter("country_name", countryName)
                .setParameter("from_date", date1)
                .setParameter("to_date", date2)
                .getResultList()
                .get(0));
    }

    /**
     * Creates query to DB to find the average number of employees in companies in the country in period of time
     *
     * @param date1       - start date of the period
     * @param date2       - end date of the period
     * @param countryName - country's name
     * @return the Integer value of the average number of employees
     */
    public int findAvgNumberOfEmployeesInCompanies(String countryName, Date date1, Date date2) {
        return ResultMapper.getInteger(em.createNamedQuery(Country.AVG_NUM_OF_EMP_IN_COMPANIES)
                .setParameter("country_name", countryName)
                .setParameter("from_date", date1)
                .setParameter("to_date", date2)
                .getResultList()
                .get(0));
    }

    /**
     * Creates query to DB to find the average experience of employees in the country in period of time
     *
     * @param date1       - start date of the period
     * @param date2       - end date of the period
     * @param countryName - country's name
     * @return the Integer value of the average experience
     */
    public int findAvgExperience(String countryName, Date date1, Date date2) {
        return ResultMapper.getInteger(em.createNamedQuery(Country.AVG_EXPERIENCE)
                .setParameter("country_name", countryName)
                .setParameter("from_date", date1)
                .setParameter("to_date", date2)
                .getResultList()
                .get(0));
    }

    /**
     * Creates query to DB to find the average age of employees in the country in period of time
     *
     * @param date1       - start date of the period
     * @param date2       - end date of the period
     * @param countryName - country's name
     * @return the Integer value of the average experience
     */
    public int findAvgAge(String countryName, Date date1, Date date2) {
        return ResultMapper.getInteger(em.createNamedQuery(Country.AVG_AGE)
                .setParameter("country_name", countryName)
                .setParameter("from_date", date1)
                .setParameter("to_date", date2)
                .getResultList()
                .get(0));

    }

    /**
     * Creates query to DB to find employee profiles for all countries
     *
     * @param date1       - start date of the period
     * @param date2       - end date of the period
     * @return the map of employee profiles with country name key
     */
    public Map<String, EmployeeProfileDTO> getEmployeeProfiles(Date date1, Date date2){
        return new EmployeeProfileDTOResultMapper().map(em.createNamedQuery(Country.EMPLOYEE_PROFILES)
                .setParameter("from_date", date1)
                .setParameter("to_date", date2)
                .getResultList());
    }


    /**
     * Creates query to DB to find profiles for all countries
     *
     * @param date1       - start date of the period
     * @param date2       - end date of the period
     * @return the map of country profiles with country name key
     */
    public Map<String, CountryProfileDTO> getProfiles(Date date1, Date date2){
        return new CountryProfileDTOResultMapper().map(em.createNamedQuery(Country.COUNTRY_PROFILES)
                .setParameter("from_date", date1)
                .setParameter("to_date", date2)
                .getResultList());
    }

    /**
     * Sets Country.class as a persistent class
     */
    public CountryDAO() {
        setPersistentClass(Country.class);
    }

}
