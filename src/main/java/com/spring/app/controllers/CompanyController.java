package com.spring.app.controllers;

import com.spring.app.domain.Company;
import com.spring.app.dto.CompanyDTO;
import com.spring.app.services.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * CompanyController
 * All activities with companies
 *
 * @author Lyubov Ruzanova
 */
@ResponseBody
@RestController
@RequestMapping(value = "/companies")
public class CompanyController {

    private CompanyService service;

    public CompanyController(@Autowired CompanyService service){
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<CompanyDTO>> getList() {
        return new ResponseEntity<>(service.getList(), HttpStatus.OK);
    }

    @PostMapping
    @ResponseStatus(value = HttpStatus.OK)
    public void add(@RequestBody CompanyDTO dto){
        Company company = dto.toEntity();
        service.save(company);
    }

}
