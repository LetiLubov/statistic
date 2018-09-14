package com.spring.app.services;

import com.spring.app.domain.Vacancy;
import com.spring.app.domain.dao.VacancyDAO;
import com.spring.app.dto.VacancyDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Service for vacancy
 * Save new entry to db
 * Get list of all entries from db
 *
 * @author Lyubov Ruzanova
 */
@Service
public class VacancyService {

    private VacancyDAO repository;

    /**
     * Inject a vacancy repository
     * @param repository - vacancy repository
     */
    public VacancyService(@Autowired VacancyDAO repository) {
        this.repository = repository;
    }

    /**
     * Get all vacancies from repository and convert them to VacancyDTO format
     * @return list of vacancies
     */
    public List<VacancyDTO> getList(){
        return repository.findAll()
                            .stream()
                            .map(v -> new VacancyDTO().fromEntity(v))
                            .collect(Collectors.toList());
    }

    /**
     * Save a new vacancy to DB
     * @param vacancy - the vacancy to save in DB
     */
    public void save(Vacancy vacancy){
        repository.create(vacancy);
    }
}
