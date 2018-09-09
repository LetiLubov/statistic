package com.spring.app.domain.dao;

import org.springframework.stereotype.Repository;

@Repository
public class VacancyDAO extends GenericDaoImpl {

    public VacancyDAO(){
        setPersistentClass(VacancyDAO.class);
    }
}
