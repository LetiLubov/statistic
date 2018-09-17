package com.spring.app.controllers;

import com.spring.app.EconomicLevel;
import com.spring.app.domain.Company;
import com.spring.app.domain.Country;
import com.spring.app.domain.Employee;
import com.spring.app.domain.Vacancy;
import com.spring.app.services.CompanyService;
import com.spring.app.services.CountryService;
import com.spring.app.services.EmployeeService;
import com.spring.app.services.VacancyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;
import java.util.Date;

/**
 * Rest controller to initialize DB for testing
 *
 * @author Lyubov Ruzanova
 */
@RestController
public class InitDBController {

    private final VacancyService vacancyService;
    private final CompanyService companyService;
    private final CountryService countryService;
    private final EmployeeService employeeService;

    /**
     * Inject all services
     *
     * @param companyService  - company service
     * @param countryService  - country service
     * @param employeeService - employee service
     * @param vacancyService  - vacancy service
     */
    public InitDBController(@Autowired VacancyService vacancyService,
                            @Autowired CompanyService companyService,
                            @Autowired CountryService countryService,
                            @Autowired EmployeeService employeeService) {
        this.vacancyService = vacancyService;
        this.companyService = companyService;
        this.countryService = countryService;
        this.employeeService = employeeService;
    }

    /**
     * Database initialization using test data
     */
    @PostConstruct
    public ResponseEntity initDB() {
        Country country1 = new Country();
        country1.setEconomicLevel(EconomicLevel.GOOD);
        country1.setName("rus");
        countryService.save(country1);

        Country country2 = new Country();
        country2.setEconomicLevel(EconomicLevel.GOOD);
        country2.setName("usa");
        countryService.save(country2);

        Country country3 = new Country();
        country3.setEconomicLevel(EconomicLevel.EXCELLENT);
        country3.setName("test");
        countryService.save(country3);

        Date date = new Date();
        date.setYear(62);
        Date date2 = new Date();
        date2.setTime(109);

        Company company1 = new Company();
        company1.setCountry(country1);
        company1.setName("NIC");
        company1.setDateOpened(date);
        companyService.save(company1);

        Company company2 = new Company();
        date.setYear(62);
        company2.setDateOpened(date);
        company2.setCountry(country2);
        company2.setName("Google");
        companyService.save(company2);

        Company company3 = new Company();
        company3.setCountry(country1);
        date.setYear(110);
        company3.setDateOpened(date);
        company3.setName("Telegram");
        companyService.save(company3);

        Employee employee1 = new Employee(1976, 1999);
        employeeService.save(employee1);

        Employee employee2 = new Employee(1985, 2000);
        employeeService.save(employee2);

        Vacancy vacancy3 = new Vacancy();
        date.setYear(100);
        date2.setYear(105);
        vacancy3.setDateClosed(date2);
        vacancy3.setDateOpened(date);
        vacancy3.setCompany(company1);
        vacancy3.setEmployee(employee1);
        vacancy3.setOpened(true);
        vacancy3.setSalary(1500);
        vacancy3.setName("vac1");
        vacancyService.save(vacancy3);

        date.setYear(105);
        date2.setYear(108);

        vacancy3 = new Vacancy();
        vacancy3.setDateClosed(date2);
        vacancy3.setDateOpened(date);
        vacancy3.setCompany(company1);
        vacancy3.setEmployee(employee1);
        vacancy3.setOpened(true);
        vacancy3.setSalary(1000);
        vacancy3.setName("vac2");
        vacancyService.save(vacancy3);

        date.setYear(106);
        date2.setYear(115);

        vacancy3 = new Vacancy();
        vacancy3.setDateClosed(date2);
        vacancy3.setDateOpened(date);
        vacancy3.setCompany(company1);
        vacancy3.setEmployee(employee1);
        vacancy3.setOpened(true);
        vacancy3.setSalary(1000);
        vacancy3.setName("vac3");
        vacancyService.save(vacancy3);

        return new ResponseEntity(HttpStatus.OK);
    }
}
