package com.spring.app.domain.dao;

import com.spring.app.domain.Country;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

/**
 * DAO for Country
 * Has default features
 *
 * @author Lyubov Ruzanova
 * {@inheritDoc}
 * And special query to get a value of average salary by country name
 */
@Repository
public class CountryDAO extends GenericDaoImpl<Country> {

    /**
     * Create query to DB to find out the average salary of a country in period of time
     *
     * @param countryName - country's name
     * @return the double value of the average salary
     */
    public Double findMeanSalary(String countryName, int data1, int data2) {
        return (Double) em.createNamedQuery(Country.MEAN_SALARY)
                .setParameter(1, countryName)
                .setParameter(2, data1)
                .setParameter(3, data2)
                .getSingleResult();
    }

    /**
     * Create query to DB to find out the average number of employees in country companies in period of time
     *
     * @param countryName - country's name
     * @return the Integer value of the average number of employees
     */
    public Integer findAvgNumberOfEmployees(String countryName, int data) {
        Number singleResult = (Number) em.createNamedQuery(Country.AVG_NUMBER_OF_EMPLOYEES) //потому что иногда возвращает биг десмиаль
                .setParameter(1, countryName)
                .setParameter(2, data)
                .getSingleResult();
        if (singleResult == null)
            return null;
        return singleResult.intValue();
    }

    /**
     * Create query to DB to find out the average experience of a country
     *
     * @param countryName - country's name
     * @return the Integer value of the average experience
     */
    public Integer findAvgExperience(String countryName, int year) {
        Number singleResult = (Number) em.createNamedQuery(Country.AVG_EXPERIENCE)
                .setParameter(1, countryName)
                .setParameter(2, year)
                .getSingleResult();
        if (singleResult == null)
            return null;
        return singleResult.intValue();
    }

    /**
     * Create query to DB to find out the average age of a country
     *
     * @param countryName - country's name
     * @return the Integer value of the average experience
     */
    public Integer findAvgAge(String countryName, int year) {
        Number singleResult = (Number) em.createNamedQuery(Country.AVG_AGE)
                .setParameter(1, countryName)
                .setParameter(2, year)
                .getSingleResult();
        if (singleResult == null)
            return null;
        return singleResult.intValue();
    }

    /**
     * Set Country.class as a persistent class
     */
    public CountryDAO() {
        setPersistentClass(Country.class);
    }

}
