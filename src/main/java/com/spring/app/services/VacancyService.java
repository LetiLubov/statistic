package com.spring.app.services;

import com.spring.app.domain.Vacancy;
import com.spring.app.domain.dao.VacancyDAO;
import com.spring.app.dto.VacancyDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class VacancyService {
    @Autowired
    private VacancyDAO repository;

    public List<VacancyDTO> getAllVacancy(){
        return repository.getAllVacancies()
                            .stream()
                            .map(v -> new VacancyDTO().fromEntity(v))
                            .collect(Collectors.toList());
    }

    public void saveVacancy(Vacancy vacancy){
        repository.create(vacancy);
    }
}
