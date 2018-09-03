package com.spring.app.controllers;

import com.spring.app.CountryLevel;
import com.spring.app.domain.Country;
import com.spring.app.repos.CountryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

@Controller
public class CountryController {
    @Autowired
    private CountryRepository countryRepository;

    @GetMapping("countries")
    public String main(Map<String, Object> model) {
        Iterable<Country> countries = countryRepository.findAll();

        model.put("countries", countries);

        return "country";
    }

    @PostMapping("countries")
    public String add(@RequestParam String name, Map<String, Object> model) {
        Country country = new Country(name);
        countryRepository.save(country);

        Iterable<Country> countries = countryRepository.findAll();

        model.put("countries", countries);

        return "country";
    }

}
