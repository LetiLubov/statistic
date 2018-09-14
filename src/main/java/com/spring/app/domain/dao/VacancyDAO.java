package com.spring.app.domain.dao;

import com.spring.app.domain.Vacancy;
import org.springframework.stereotype.Repository;

/**
 * DAO for Vacancy
 * Has default features
 * @see GenericDAO
 *
 * @author Lyubov Ruzanova
 */
@Repository
public class VacancyDAO extends GenericDaoImpl<Vacancy> {

    public VacancyDAO(){
        setPersistentClass(Vacancy.class);
    }
}
