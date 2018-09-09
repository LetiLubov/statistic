package com.spring.app.controllers;

import com.spring.app.domain.Vacancy;
import com.spring.app.dto.VacancyDTO;
import com.spring.app.services.VacancyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * VacancyController
 * All activities with vacancies
 * @author lyubov
 */
@RestController
@RequestMapping("/vacancies")
public class VacancyController {
    @Autowired
    private VacancyService service;

    @GetMapping
    public ResponseEntity<List<VacancyDTO>> listAllVacancies() {
        return new ResponseEntity<>(service.getAllVacancy(), HttpStatus.OK);
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Vacancy> addVacancy(@RequestBody VacancyDTO vacancyDTO) {
        Vacancy vacancy = vacancyDTO.toEntity();
        service.saveVacancy(vacancy);
        return new ResponseEntity<>(vacancy, HttpStatus.OK);
    }
}
