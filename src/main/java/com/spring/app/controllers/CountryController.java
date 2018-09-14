package com.spring.app.controllers;

import com.spring.app.domain.Country;
import com.spring.app.dto.CountryDTO;
import com.spring.app.services.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * CountryController
 * All activities with countries
 * @author Lyubov Ruzanova
 */
@ResponseBody
@RestController
@RequestMapping("/countries")
public class CountryController {
    private final CountryService service;
    private final static String MEAN_SALARY_TEXT_MESSAGE = "Mean salary in %s is %f";

    public CountryController(@Autowired CountryService service) {
        this.service = service;
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<CountryDTO>> getList() {
        return new ResponseEntity<>(service.getList(), HttpStatus.OK);
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<CountryDTO> add(@RequestBody CountryDTO dto) {
        Country country = dto.toEntity();
        service.save(country);
        return new ResponseEntity<>(dto, HttpStatus.OK);
    }

    @GetMapping(value = "{countryName}/mean-salary", produces = MediaType.TEXT_PLAIN_VALUE)
    public ResponseEntity<String> findAverageSalaryByCountry(@PathVariable String countryName) {
        String message =  String.format(MEAN_SALARY_TEXT_MESSAGE, countryName, service.getMeanSalary(countryName));
        return new ResponseEntity<>(message, HttpStatus.OK);
    }

}
