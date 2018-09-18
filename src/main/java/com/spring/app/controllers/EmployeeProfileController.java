package com.spring.app.controllers;

import com.spring.app.dto.DataRange;
import com.spring.app.dto.EmployeeProfileDTO;
import com.spring.app.services.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * Provides statistical information about average indicators for developers in the countries
 *
 * @author Lyubov Ruzanova
 */
@RestController
@RequestMapping(value = "/employee-profiles",
        consumes = MediaType.APPLICATION_JSON_VALUE,
        produces = MediaType.APPLICATION_JSON_VALUE)
public class EmployeeProfileController {
    private final CountryService countryService;

    /**
     * Injects a country service
     *
     * @param service - country service
     */
    public EmployeeProfileController(@Autowired CountryService service) {
        this.countryService = service;
    }

    /**
     * Sends requests to the service to get all statistical information
     *
     * @param data - period of time
     * @return map of employee's profile DTO by the country's name key
     */
    @ResponseBody
    @PostMapping
    public ResponseEntity<Map<String, EmployeeProfileDTO>> getProfiles(@RequestBody DataRange data) {
        Map<String, EmployeeProfileDTO> map = countryService.getEmployeeProfiles(data.getValidFrom(), data.getValidTo());
        return ResponseEntity.ok(map);
    }
}
