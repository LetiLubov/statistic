package com.spring.app.controllers;

import com.spring.app.MessageEnum;
import com.spring.app.domain.Country;
import com.spring.app.dto.CountryDTO;
import com.spring.app.dto.DataRange;
import com.spring.app.services.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Rest controller for a countries
 * Provide all actions with countries
 *
 * @author Lyubov Ruzanova
 */
@RestController
@RequestMapping(value = "/countries", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
public class CountryController {
    private final CountryService service;

    /**
     * Inject a country service
     *
     * @param service - country service
     */
    public CountryController(@Autowired CountryService service) {
        this.service = service;
    }

    /**
     * Send a request to the service to get all countries
     *
     * @return list of countries
     */
    @GetMapping
    @ResponseBody
    public ResponseEntity<List<CountryDTO>> getList() {
        return ResponseEntity.ok(service.getList());
    }

    /**
     * Send a request to the service to save a new instance
     *
     * @param dto - country info storage
     * @return countryDTO object
     */
    @PostMapping
    @ResponseBody
    public ResponseEntity<CountryDTO> add(@RequestBody CountryDTO dto) {
        Country country = dto.toEntity();
        service.save(country);
        return ResponseEntity.ok(dto);
    }

    /**
     * Get the average salary by country name from country's service
     *
     * @param countryName - country's name
     * @return the double value of the average salary
     */
    @ResponseBody
    @PostMapping(value = "{countryName}/mean-salary")
    public ResponseEntity<String> findAverageSalaryByCountry(@PathVariable String countryName,
                                                             @RequestBody DataRange data) {
        Double averageSalary = service.getMeanSalary(countryName, data.getValidFrom(), data.getValidTo());
        if (averageSalary == null) {
            return ResponseEntity.ok(MessageEnum.ERROR_NO_SALARY_INFO_FOUND.getErrorMessage());
        }
        return ResponseEntity.ok(MessageEnum.MEAN_SALARY.getErrorMessage(data.getValidFromToString(),
                                                                         data.getValidToToString(),
                                                                         countryName,
                                                                         averageSalary));
    }

    /**
     * Get the average number of employee's experience by country from country's service
     *
     * @param countryName - country's name
     * @return the Integer value of the average experience
     */
    @ResponseBody
    @PostMapping(value = "{countryName}/avg-experience")
    public ResponseEntity<String> findAverageExperienceByCountry(@PathVariable String countryName,
                                                                 @RequestBody DataRange data) {
        Integer experience = service.getAvgExperience(countryName, data.getValidFrom(), data.getValidTo());
        if (experience == null) {
            return ResponseEntity.ok(MessageEnum.ERROR_NO_EMP_FOUND.getErrorMessage());
        }
        return ResponseEntity.ok(MessageEnum.AVG_EXPERIENCE.getErrorMessage(countryName, experience));
    }

    /**
     * Get the average employee's age by country from country's service
     *
     * @param countryName - country's name
     * @return the Integer value of the average age
     */
    @ResponseBody
    @PostMapping(value = "{countryName}/avg-age")
    public ResponseEntity<String> findAverageAgeByCountry(@PathVariable String countryName,
                                                          @RequestBody DataRange data) {
        Integer age = service.getAvgAge(countryName, data.getValidFrom(), data.getValidTo());
        if (age == null) {
            return ResponseEntity.ok(MessageEnum.ERROR_NO_EMP_FOUND.getErrorMessage());
        }
        return ResponseEntity.ok(MessageEnum.AVG_AGE.getErrorMessage(countryName, age));
    }


    /**
     * Get the average number of employees in companies by country from country's service
     *
     * @param countryName - country's name
     * @return the Integer value of the average number of employees
     */
    @ResponseBody
    @PostMapping(value = "{countryName}/average-number-of-employees")
    public ResponseEntity<String> findAverageNumberOfEmployeesByCountry(@PathVariable String countryName,
                                                                        @RequestBody DataRange data) {
        Integer averageNumberOfEmployees = service.getAvgNumberOfEmployees(countryName, data.getValidFrom(), data.getValidTo());
        if (averageNumberOfEmployees == null) {
            return ResponseEntity.ok(MessageEnum.ERROR_NO_EMP_FOUND.getErrorMessage());
        }
        return ResponseEntity.ok(MessageEnum.AVG_NUM_OF_EMP.getErrorMessage(countryName, averageNumberOfEmployees));
    }

}
