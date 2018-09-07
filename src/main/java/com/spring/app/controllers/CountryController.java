package com.spring.app.controllers;

import com.spring.app.domain.Country;
import com.spring.app.repos.CountryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

/**
 * CountryController
 *
 * @author lyubov
 */
@Controller
public class CountryController {
    @Autowired
    private CountryRepository countryRepository;

    @GetMapping("countries")
    public ResponseEntity<Iterable<Country>> main(Map<String, Object> model) {
        Iterable<Country> countries = countryRepository.findAll();
        return new ResponseEntity<>(countries, HttpStatus.OK);
    }

    @PostMapping("countries")
    public ResponseEntity<Country> add(@RequestParam String name, Map<String, Object> model) {
        Country country = new Country(name);
        countryRepository.save(country);
        return new ResponseEntity<>(country, HttpStatus.OK);
    }

}
