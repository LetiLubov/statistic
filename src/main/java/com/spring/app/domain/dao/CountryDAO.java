package com.spring.app.domain.dao;

import com.spring.app.domain.Country;
import org.springframework.stereotype.Repository;

/**
 * DAO for Country
 * Has default features
 * @see GenericDAO
 * And special query to get a value of average salary by country name
 *
 * @author Lyubov Ruzanova
 */
@Repository
public class CountryDAO extends GenericDaoImpl<Country> {

    public Double findMeanSalary(String countryName){
        return (Double) em.createNativeQuery(Country.MEAN_SALARY)
                .setParameter(1, countryName)
                .getSingleResult();
    }

    public CountryDAO(){
        setPersistentClass(Country.class);
    }

}
