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
 * @author Lyubov Ruzanova
 */
@ResponseBody
@RestController
@RequestMapping("/vacancies")
public class VacancyController {
    private final VacancyService service;

    public VacancyController(@Autowired VacancyService service) {
        this.service = service;
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<VacancyDTO>> getList() {
        return new ResponseEntity<>(service.getList(), HttpStatus.OK);
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<VacancyDTO> add(@RequestBody VacancyDTO vacancyDTO) {
        Vacancy vacancy = vacancyDTO.toEntity();
        service.save(vacancy);
        return new ResponseEntity<>(vacancyDTO, HttpStatus.OK);
    }
}
