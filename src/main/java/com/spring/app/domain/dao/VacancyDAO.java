package com.spring.app.domain.dao;

import com.spring.app.domain.Vacancy;
import org.springframework.stereotype.Repository;

@Repository
public class VacancyDAO extends GenericDaoImpl<Vacancy> {

    public VacancyDAO(){
        setPersistentClass(Vacancy.class);
    }
}
