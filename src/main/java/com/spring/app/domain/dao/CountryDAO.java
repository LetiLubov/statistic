package com.spring.app.domain.dao;

import com.spring.app.domain.Country;
import com.spring.app.services.mappers.DoubleResultMapper;
import com.spring.app.services.mappers.IntegerResultMapper;
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
                .setParameter("countryName", countryName)
                .setParameter("fromDate", date1)
                .setParameter("toDate", date2)
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
    public Integer findAvgNumberOfEmployees(String countryName, Date date1, Date date2) {
        return new IntegerResultMapper().map(em.createNamedQuery(Country.AVG_NUMBER_OF_EMPLOYEES) //потому что иногда возвращает биг десмиаль
                .setParameter("countryName", countryName)
                .setParameter("fromDate", date1)
                .setParameter("toDate", date2)
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
                .setParameter("countryName", countryName)
                .setParameter("fromDate", date1)
                .setParameter("toDate", date2)
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
                .setParameter("countryName", countryName)
                .setParameter("fromDate", date1)
                .setParameter("toDate", date2)
                .getResultList());
    }

    /**
     * Set Country.class as a persistent class
     */
    public CountryDAO() {
        setPersistentClass(Country.class);
    }

}
