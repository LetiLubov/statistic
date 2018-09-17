package com.spring.app.domain.dao;

import com.spring.app.EconomicLevel;
import com.spring.app.domain.Country;
import com.spring.app.services.mappers.DoubleResultMapper;
import com.spring.app.services.mappers.EconomyLevelResultMapper;
import com.spring.app.services.mappers.IntegerResultMapper;
import com.spring.app.services.mappers.LongResultMapper;
import org.springframework.stereotype.Repository;

import java.util.Date;

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
     * Create query to DB to find out the average salary of the country in period of time
     *
     * @param date1       - start date of the period
     * @param date2       - end date of the period
     * @param countryName - country's name
     * @return the double value of the average salary
     */
    public Double findMeanSalary(String countryName, Date date1, Date date2) {
        return new DoubleResultMapper().map(em.createNamedQuery(Country.MEAN_SALARY)
                .setParameter("country_name", countryName)
                .setParameter("from_date", date1)
                .setParameter("to_date", date2)
                .getResultList());
    }

    /**
     * Create query to DB to find out the average number of employees in companies in the country in period of time
     *
     * @param date1       - start date of the period
     * @param date2       - end date of the period
     * @param countryName - country's name
     * @return the Integer value of the average number of employees
     */
    public Integer findAvgNumberOfEmployeesInCompanies(String countryName, Date date1, Date date2) {
        return new IntegerResultMapper().map(em.createNamedQuery(Country.AVG_NUM_OF_EMP_IN_COMPANIES)
                .setParameter("country_name", countryName)
                .setParameter("from_date", date1)
                .setParameter("to_date", date2)
                .getResultList());

    }

    /**
     * Create query to DB to find out the average experience of employees in the country in period of time
     *
     * @param date1       - start date of the period
     * @param date2       - end date of the period
     * @param countryName - country's name
     * @return the Integer value of the average experience
     */
    public Integer findAvgExperience(String countryName, Date date1, Date date2) {
        return new IntegerResultMapper().map(em.createNamedQuery(Country.AVG_EXPERIENCE)
                .setParameter("country_name", countryName)
                .setParameter("from_date", date1)
                .setParameter("to_date", date2)
                .getResultList());
    }

    /**
     * Create query to DB to find out the average age of employees in the country in period of time
     *
     * @param date1       - start date of the period
     * @param date2       - end date of the period
     * @param countryName - country's name
     * @return the Integer value of the average experience
     */
    public Integer findAvgAge(String countryName, Date date1, Date date2) {
        return new IntegerResultMapper().map(em.createNamedQuery(Country.AVG_AGE)
                .setParameter("country_name", countryName)
                .setParameter("from_date", date1)
                .setParameter("to_date", date2)
                .getResultList());
    }

    /**
     * Create query to DB to find out the number of employees in the country in period of time
     *
     * @param date1       - start date of the period
     * @param date2       - end date of the period
     * @param countryName - country's name
     * @return the Long number of employees in country
     */
    public Long findNumberOfEmployees(String countryName, Date date1, Date date2) {
        return new LongResultMapper().map(em.createNamedQuery(Country.NUMBER_OF_EMPLOYEES)
                .setParameter("country_name", countryName)
                .setParameter("from_date", date1)
                .setParameter("to_date", date2)
                .getResultList());
    }

    /**
     * Create query to DB to find out the number of vacancies in the country in period of time
     *
     * @param date1       - start date of the period
     * @param date2       - end date of the period
     * @param countryName - country's name
     * @return the Long number of vacancies in country
     */
    public Long findNumberOfVacancies(String countryName, Date date1, Date date2) {
        return new LongResultMapper().map(em.createNamedQuery(Country.NUMBER_OF_VACANCIES)
                .setParameter("country_name", countryName)
                .setParameter("from_date", date1)
                .setParameter("to_date", date2)
                .getResultList());
    }

    /**
     * Create query to DB to find out the economy level of the country
     *
     * @param countryName - country's name
     * @return the EconomicLevel value in country
     */
    public EconomicLevel getLevelByCountryName(String countryName) {
        return new EconomyLevelResultMapper().map(em.createNamedQuery(Country.LEVEL_OF_COUNTRY)
                .setParameter("country_name", countryName)
                .getResultList());
    }

    /**
     * Set Country.class as a persistent class
     */
    public CountryDAO() {
        setPersistentClass(Country.class);
    }

}
