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
 * @author lyubov
 */
@RestController
@RequestMapping("/countries")
public class CountryController {
    private CountryService service;

    public CountryController(@Autowired CountryService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<CountryDTO>> getList() {
        return new ResponseEntity<>(service.getAllCountries(), HttpStatus.OK);
    }

    @PostMapping (consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Country> add(@RequestBody CountryDTO dto) {
        Country country = dto.toEntity();
        service.saveCountry(country);
        return new ResponseEntity<>(country, HttpStatus.OK);
    }
}
