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

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<CompanyDTO>> getList() {
        System.out.println(service.getList());
        return new ResponseEntity<>(service.getList(), HttpStatus.OK);
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Company> add(@RequestBody CompanyDTO dto) {
        Company company = dto.toEntity();
        service.save(company);
        return new ResponseEntity<>(company, HttpStatus.OK);
    }

}
