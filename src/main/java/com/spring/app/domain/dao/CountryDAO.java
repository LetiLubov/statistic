package com.spring.app.domain.dao;

import com.spring.app.domain.Country;
import com.spring.app.dto.CountryDTO;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CountryDAO extends GenericDaoImpl<Country> {

    public Double findMeanSalary(String countryName){
        return (Double) em.createNativeQuery(Country.MEAN_SALARY)
                .setParameter(1, countryName)
                .getSingleResult();
    }

    public List<Country> findAll(){
        return em.createNativeQuery(Country.ALL_COUNTRIES)
                    .getResultList();
    }
}
