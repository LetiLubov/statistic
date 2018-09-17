package com.spring.app.controllers;

import com.spring.app.dto.DataRange;
import com.spring.app.dto.EmployeeProfileDTO;
import com.spring.app.services.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * Composite statistical information about average indicators for developers in the country
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
     * Inject a country service
     *
     * @param service - country service
     */
    public EmployeeProfileController(@Autowired CountryService service) {
        this.countryService = service;
    }

    /**
     * Send requests to the service to get all statistical information
     *
     * @param countryName - name of the country
     * @param data        - period of time
     * @return employee's profile DTO of this country
     */
    @ResponseBody
    @PostMapping(value = "/{countryName}")
    public ResponseEntity<EmployeeProfileDTO> getProfile(@PathVariable String countryName, @RequestBody DataRange data) {
        Double salary = countryService.getMeanSalary(countryName, data.getValidFrom(), data.getValidTo());
        Integer experience = countryService.getAvgExperience(countryName, data.getValidFrom(), data.getValidTo());
        Integer age = countryService.getAvgAge(countryName, data.getValidFrom(), data.getValidTo());
        Integer numberOfEmployees = countryService.getAvgNumberOfEmployeesInCompanies(countryName, data.getValidFrom(), data.getValidTo());
        EmployeeProfileDTO profileDTO = new EmployeeProfileDTO();
        profileDTO.setAge(age);
        profileDTO.setSalary(salary);
        profileDTO.setExperience(experience);
        profileDTO.setNumberOfEmployees(numberOfEmployees);
        return ResponseEntity.ok(profileDTO);
    }
}
