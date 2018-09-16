package com.spring.app.controllers;

import com.spring.app.domain.Vacancy;
import com.spring.app.dto.VacancyDTO;
import com.spring.app.services.VacancyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Rest controller for a vacancies
 * Provide all actions with vacancies
 *
 * @author Lyubov Ruzanova
 */
@RestController
@RequestMapping(value = "/vacancies", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
public class VacancyController {
    private final VacancyService service;

    /**
     * Inject a vacancy service
     * @param service - vacancy service
     */
    public VacancyController(@Autowired VacancyService service) {
        this.service = service;
    }

    /**
     * Send a request to the service to get all vacancies
     * @return list of vacancies
     */
    @GetMapping
    @ResponseBody
    public ResponseEntity<List<VacancyDTO>> getList() {
        return ResponseEntity.ok(service.getList());
    }

    /**
     * Send a request to the service to save a new instance
     * @param dto - vacancy info
     * @return vacancyDTO object
     */
    @PostMapping
    @ResponseBody
    public ResponseEntity<VacancyDTO> add(@RequestBody VacancyDTO dto) {
        Vacancy vacancy = dto.toEntity();
        service.save(vacancy);
        return ResponseEntity.ok(dto);
    }
}
