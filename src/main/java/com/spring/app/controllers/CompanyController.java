package com.spring.app.controllers;

import com.spring.app.domain.Company;
import com.spring.app.repos.CompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * CompanyController
 * All activities with companies
 * @author lyubov
 */
@RestController("companies")
public class CompanyController {
    @Autowired
    private CompanyRepository companyRepository;

    @GetMapping
    public ResponseEntity<Iterable<Company>> listAllCompanies() {
        Iterable<Company> companies = companyRepository.findAll();
        return new ResponseEntity<>(companies, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Company> addCompany(@RequestParam String name) {
        Company company = new Company(name);
        companyRepository.save(company);
        return new ResponseEntity<>(company, HttpStatus.OK);
    }

}
