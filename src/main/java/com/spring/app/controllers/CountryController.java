package com.spring.app.controllers;

import com.spring.app.domain.Country;
import com.spring.app.dto.CountryDTO;
import com.spring.app.services.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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
    private CountryService service;

    public CountryController(@Autowired CountryService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<CountryDTO>> getList() {
        return new ResponseEntity<>(service.getList(), HttpStatus.OK);
    }

    @PostMapping
    @ResponseStatus(value = HttpStatus.OK)
    public void add(@RequestBody CountryDTO dto) {
        Country country = dto.toEntity();
        service.save(country);
    }
}
