package com.spring.app.controllers;

import com.spring.app.domain.Company;
import com.spring.app.dto.CompanyDTO;
import com.spring.app.services.CompanyService;
import com.spring.app.services.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * CompanyController
 * All activities with companies
 *
 * @author lyubov
 */
@RestController
@RequestMapping("/companies")
public class CompanyController {

    private CompanyService service;

    public CompanyController(@Autowired CompanyService service){
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<CompanyDTO>> getList() {
        return new ResponseEntity<>(service.getAllCompanies(), HttpStatus.OK);
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Company> add(@RequestBody CompanyDTO dto) {
        Company company = dto.toEntity();
        service.saveCompany(company);
        return new ResponseEntity<>(company, HttpStatus.OK);
    }

}
