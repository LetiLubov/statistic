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

    public Double findMeanSalary(String countryName) {
        return (Double) em.createNamedQuery(Country.MEAN_SALARY)
                .setParameter(1, countryName)
                .getSingleResult();
    }

    public CountryDAO() {
        setPersistentClass(Country.class);
    }

}
