package com.spring.app.domain.dao;

import com.spring.app.domain.Country;
import org.springframework.stereotype.Repository;

import javax.persistence.Query;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

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
     * Create query to DB to find out the average salary of a country
     * @param countryName - country's name
     * @return the double value of the average salary
     */
    public Double findMeanSalary(String countryName) {
        return (Double) em.createNamedQuery(Country.MEAN_SALARY)
                .setParameter(1, countryName)
                .getSingleResult();
    }

    /**
     * Set Country.class as a persistent class
     */
    public CountryDAO() {
        setPersistentClass(Country.class);
    }

}
