package com.spring.app.domain.dao;

import com.spring.app.domain.Vacancy;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class VacancyDAO extends GenericDaoImpl {
    public List<Vacancy> getAllVacancies(){
        return em.createNativeQuery(Vacancy.ALL_VACANCIES)
                .getResultList();
    }
}
