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

import java.util.Map;

/**
 * CompanyController
 *
 * @author lyubov
 */
@Controller
public class CompanyController {
    @Autowired
    private CompanyRepository companyRepository;

    @GetMapping("companies")
    public ResponseEntity<Iterable<Company>> main(Map<String, Object> model) {
        Iterable<Company> companies = companyRepository.findAll();
        return new ResponseEntity<>(companies, HttpStatus.OK);
    }

    @PostMapping("companies")
    public ResponseEntity<Company> add(@RequestParam String name, Map<String, Object> model) {
        Company company = new Company(name);
        companyRepository.save(company);
        return new ResponseEntity<>(company, HttpStatus.OK);
    }

}
