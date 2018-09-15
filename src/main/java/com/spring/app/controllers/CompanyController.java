package com.spring.app.controllers;

import com.spring.app.domain.Company;
import com.spring.app.dto.CompanyDTO;
import com.spring.app.services.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Rest controller for a companies
 * Provide all actions with companies
 *
 * @author Lyubov Ruzanova
 */
@ResponseBody
@RestController
@RequestMapping(value = "/companies")
public class CompanyController {
    private final CompanyService service;

    /**
     * Inject a company service
     * @param service - company service
     */
    public CompanyController(@Autowired CompanyService service){
        this.service = service;
    }

    /**
     * Send a request to the service to get all companies
     * @return list of companies
     */
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<CompanyDTO>> getList() {
        return new ResponseEntity<>(service.getList(), HttpStatus.OK);
    }

    /**
     * Send a request to the service to save a new instance
     * @param dto - company info storage
     * @return companyDTO object
     */
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<CompanyDTO> add(@RequestBody CompanyDTO dto){
        Company company = dto.toEntity();
        service.save(company);
        return new ResponseEntity<>(dto, HttpStatus.OK);
    }

}
