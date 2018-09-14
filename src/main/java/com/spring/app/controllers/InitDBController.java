package com.spring.app.controllers;

import com.spring.app.EconomyLevel;
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
 * InitDBController
 *
 * @author Lyubov Ruzanova
 */
@RestController
public class InitDBController {

    private VacancyService vacancyService;
    private CompanyService companyService;
    private CountryService countryService;
    private EmployeeService employeeService;

    //todo: Have i need to write annotations on each field?

    public InitDBController(@Autowired VacancyService vacancyService,
                            @Autowired CompanyService companyService,
                            @Autowired CountryService countryService,
                            @Autowired EmployeeService employeeService) {
        this.vacancyService = vacancyService;
        this.companyService = companyService;
        this.countryService = countryService;
        this.employeeService = employeeService;
    }

    @PostConstruct
    public ResponseEntity initDB(){
        Country country1 = new Country();
        country1.setEconomyLevel(EconomyLevel.GOOD);
        country1.setName("rus");
        countryService.save(country1);

        Country country2 = new Country();
        country2.setEconomyLevel(EconomyLevel.GOOD);
        country2.setName("usa");
        countryService.save(country2);

        Country country3 = new Country();
        country3.setEconomyLevel(EconomyLevel.EXCELLENT);
        country3.setName("test");
        countryService.save(country3);

        Company company1 = new Company();
        company1.setCountry(country1);
        company1.setName("NIC");
        companyService.save(company1);

        Company company2 = new Company();
        company2.setCountry(country2);
        company2.setName("Google");
        companyService.save(company2);

        Company company3 = new Company();
        company3.setCountry(country1);
        company3.setName("Telegram");
        companyService.save(company3);

        Date date = new Date();
        date.setYear(1993);
        Date date2 = new Date();
        date.setYear(1995);

        Employee employee1 = new Employee(1976, 1999);
        employeeService.save(employee1);

        date2.setYear(1994);
        Employee employee2 = new Employee(1985, 2000);
        employeeService.save(employee2);

        Vacancy vacancy3 = new Vacancy();
        vacancy3.setDateClosed(date);
        vacancy3.setDateOpened(date);
        vacancy3.setCompany(company1);
        vacancy3.setEmployee(employee1);
        vacancy3.setOpened(true);
        vacancy3.setSalary(1500);
        vacancy3.setName("vac1");
        vacancyService.save(vacancy3);

        date.setYear(2012);
        date.setYear(2014);
        vacancy3 = new Vacancy();
        vacancy3.setDateClosed(date);
        vacancy3.setDateOpened(date2);
        vacancy3.setCompany(company1);
        vacancy3.setEmployee(employee2);
        vacancy3.setOpened(true);
        vacancy3.setSalary(1000);
        vacancy3.setName("vac2");
        vacancyService.save(vacancy3);

        date.setYear(2011);
        date.setYear(2014);
        vacancy3 = new Vacancy();
        vacancy3.setDateClosed(date);
        vacancy3.setDateOpened(date2);
        vacancy3.setCompany(company1);
        vacancy3.setEmployee(employee1);
        vacancy3.setOpened(true);
        vacancy3.setSalary(1000);
        vacancy3.setName("vac3");
        vacancyService.save(vacancy3);

        return new ResponseEntity(HttpStatus.OK);
    }
}
