package com.spring.app.controllers;

import com.spring.app.domain.Country;
import com.spring.app.dto.CountryDTO;
import com.spring.app.services.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Calendar;
import java.util.List;

/**
 * CountryController
 * All activities with countries
 *
 * @author Lyubov Ruzanova
 */
@ResponseBody
@RestController
@RequestMapping("/countries")
public class CountryController {
    private final CountryService service;
    private final static String MEAN_SALARY_TEXT_MESSAGE = "Mean salary between %d-%d in %s is %f";
    private final static String AVG_EXPERIENCE_TEXT_MESSAGE = "Average experience of employees in %s is %d";
    private final static String AVG_AGE_TEXT_MESSAGE = "Average age of employees in %s is %d";
    private final static String AVG_NUM_OF_EMP_TEXT_MESSAGE = "Average number of employees in companies in %s is %d";

    private final static String NO_SALARY_INFO_FOUND_ERROR_TEXT_MESSAGE = "There is no information about the salary for this period";
    private final static String NO_EMP_FOUND_ERROR_TEXT_MESSAGE = "There is no information about employees for this period";

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
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<CountryDTO>> getList() {
        return new ResponseEntity<>(service.getList(), HttpStatus.OK);
    }

    /**
     * Send a request to the service to save a new instance
     *
     * @param dto - country info
     * @return countryDTO object
     */
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<CountryDTO> add(@RequestBody CountryDTO dto) {
        Country country = dto.toEntity();
        service.save(country);
        return new ResponseEntity<>(dto, HttpStatus.OK);
    }

    /**
     * Get the average salary by country from country's service
     *
     * @param countryName - country's name
     * @return the double value of the average salary
     */
    @GetMapping(value = "{countryName}/mean-salary",
            produces = MediaType.TEXT_PLAIN_VALUE)
    public ResponseEntity<String> findAverageSalaryByCountry(
            @PathVariable String countryName,
            @RequestParam(required = false, defaultValue = "0") int data1, //можно оставить примитив и вырубить дефолт
            @RequestParam(required = false) Integer data2) {
        if (data2 == null) {
            data2 = Calendar.getInstance().get(Calendar.YEAR);
        }
        Double averageSalary = service.getMeanSalary(countryName, data1, data2);

        if (averageSalary == null)
            return new ResponseEntity<>(NO_SALARY_INFO_FOUND_ERROR_TEXT_MESSAGE, HttpStatus.OK);

        String message = String.format(MEAN_SALARY_TEXT_MESSAGE, data1, data2, countryName, averageSalary);
        return new ResponseEntity<>(message, HttpStatus.OK);
    }

    /**
     * Get the average employee's experience by country from country's service
     * @param countryName - country's name
     * @return the Integer value of the average experience
     */
    @GetMapping(value = "{countryName}/avg-experience",
            produces = MediaType.TEXT_PLAIN_VALUE)
    public ResponseEntity<String> findAverageExperienceByCountry(@PathVariable String countryName,
                                                                 @RequestParam(required = false) Integer data) {
        if (data == null) {
            data = Calendar.getInstance().get(Calendar.YEAR);
        }

        Integer experience = service.getAvgExperience(countryName, data);
        if (experience == null)
            return new ResponseEntity<>(NO_EMP_FOUND_ERROR_TEXT_MESSAGE, HttpStatus.OK);

        String message =  String.format(AVG_EXPERIENCE_TEXT_MESSAGE, countryName, experience);
        return new ResponseEntity<>(message, HttpStatus.OK);
    }

    /**
     * Get the average employee's age by country from country's service
     * @param countryName - country's name
     * @return the Integer value of the average experience
     */
    @GetMapping(value = "{countryName}/avg-age",
            produces = MediaType.TEXT_PLAIN_VALUE)
    public ResponseEntity<String> findAverageAgeByCountry(@PathVariable String countryName,
                                                                 @RequestParam(required = false) Integer data) {
        if (data == null) {
            data = Calendar.getInstance().get(Calendar.YEAR);
        }

        Integer age = service.getAvgAge(countryName, data);
        if (age == null)
            return new ResponseEntity<>(NO_EMP_FOUND_ERROR_TEXT_MESSAGE, HttpStatus.OK);

        String message =  String.format(AVG_AGE_TEXT_MESSAGE, countryName, age);
        return new ResponseEntity<>(message, HttpStatus.OK);
    }


    /**
     * Get the average salary by country from country's service
     *
     * @param countryName - country's name
     * @return the Integer value of the average salary
     */
    @GetMapping(value = "{countryName}/average-number-of-employees",
            produces = MediaType.TEXT_PLAIN_VALUE)
    public ResponseEntity<String> findAverageNumberOfEmployeesByCountry(
            @PathVariable String countryName,
            @RequestParam(required = false) Integer data) {
        if (data == null) {
            data = Calendar.getInstance().get(Calendar.YEAR);
        }
        Integer averageNumberOfEmployees = service.getAvgNumberOfEmployees(countryName, data);

        if (averageNumberOfEmployees == null)
            return new ResponseEntity<>(NO_EMP_FOUND_ERROR_TEXT_MESSAGE, HttpStatus.OK);

        String message = String.format(AVG_NUM_OF_EMP_TEXT_MESSAGE, countryName, averageNumberOfEmployees);
        return new ResponseEntity<>(message, HttpStatus.OK);
    }

}
