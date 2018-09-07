package com.spring.app.controllers;

import com.spring.app.domain.Country;
import com.spring.app.repos.CountryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * CountryController
 * All activities with countries
 * @author lyubov
 */
@RestController("countries")
public class CountryController {
    @Autowired
    private CountryRepository countryRepository;

    @GetMapping
    public ResponseEntity<Iterable<Country>> listAllCountries() {
        Iterable<Country> countries = countryRepository.findAll();
        return new ResponseEntity<>(countries, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Country> addCountry(@RequestParam String name) {
        Country country = new Country(name);
        countryRepository.save(country);
        return new ResponseEntity<>(country, HttpStatus.OK);
    }

}
