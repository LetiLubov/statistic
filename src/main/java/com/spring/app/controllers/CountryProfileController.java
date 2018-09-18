package com.spring.app.controllers;

import com.spring.app.dto.CountryProfileDTO;
import com.spring.app.dto.DataRange;
import com.spring.app.services.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

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
     * @param data        - period of time
     * @return country's profile DTO
     */
    @ResponseBody
    @PostMapping
    public ResponseEntity< Map<String, CountryProfileDTO>> getProfiles(@RequestBody DataRange data) {
        Map<String, CountryProfileDTO> map = countryService.getProfiles(data.getValidFrom(), data.getValidTo());
        return ResponseEntity.ok(map);
    }
}
