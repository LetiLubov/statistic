package com.spring.app.domain.dao;

import com.spring.app.domain.Vacancy;
import org.springframework.stereotype.Repository;

/**
 * DAO for Vacancy
 * Has default features {@inheritDoc}
 *
 * @author Lyubov Ruzanova
 */
@Repository
public class VacancyDAO extends GenericDaoImpl<Vacancy> {

    /**
     * Set Vacancy.class as a persistent class
     */
    public VacancyDAO(){
        setPersistentClass(Vacancy.class);
    }
}
