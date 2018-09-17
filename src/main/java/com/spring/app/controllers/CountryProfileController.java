package com.spring.app.controllers;

import com.spring.app.EconomicLevel;
import com.spring.app.dto.CountryProfileDTO;
import com.spring.app.dto.DataRange;
import com.spring.app.services.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * Composite statistical information on the performance indicators in the country
 *
 * @author Lyubov Ruzanova
 */
@RestController
@RequestMapping(value = "/country-profiles",
        consumes = MediaType.APPLICATION_JSON_VALUE,
        produces = MediaType.APPLICATION_JSON_VALUE)
public class CountryProfileController {
    private final CountryService countryService;

    /**
     * Inject a country service
     *
     * @param service - country service
     */
    public CountryProfileController(@Autowired CountryService service) {
        this.countryService = service;
    }

    /**
     * Send requests to the service to get all statistical information
     *
     * @param countryName - name of the country
     * @param data        - period of time
     * @return country's profile DTO
     */
    @ResponseBody
    @PostMapping(value = "/{countryName}")
    public ResponseEntity<CountryProfileDTO> getProfile(@PathVariable String countryName, @RequestBody DataRange data) {
        Long numberOfEmployees = countryService.getNumberOfEmployees(countryName, data.getValidFrom(), data.getValidTo());
        Long numberOfVacancies = countryService.getNumberOfVacancies(countryName, data.getValidFrom(), data.getValidTo());
        EconomicLevel economicLevel = countryService.getCountryLevel(countryName);
        CountryProfileDTO countryProfileDTO = new CountryProfileDTO();
        countryProfileDTO.setEconomicLevel(economicLevel);
        countryProfileDTO.setNumberOfEmployees(numberOfEmployees);
        countryProfileDTO.setNumberOfVacancies(numberOfVacancies);
        return ResponseEntity.ok(countryProfileDTO);
    }
}
