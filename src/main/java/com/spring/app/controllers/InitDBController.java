package com.spring.app.controllers;

import com.spring.app.QualityOfLiveIndex;
import com.spring.app.domain.Company;
import com.spring.app.domain.Country;
import com.spring.app.domain.Employee;
import com.spring.app.domain.Vacancy;
import com.spring.app.repos.CompanyRepository;
import com.spring.app.repos.CountryRepository;
import com.spring.app.repos.EmployeeRepository;
import com.spring.app.repos.VacancyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.Map;

/**
 * InitDBController
 *
 * @author lyubov
 */
@RestController
public class InitDBController {

    @Autowired
    private VacancyRepository vacancyRepository;
    @Autowired
    private CompanyRepository companyRepository;
    @Autowired
    private CountryRepository countryRepository;
    @Autowired
    private EmployeeRepository employeeRepository;

    @PostMapping("initDB")
    public ResponseEntity initDB(){
        Country country1 = Country.builder()
                .qualityOfLiveIndex(QualityOfLiveIndex.GOOD)
                .name("rus")
                .build();

        countryRepository.save(country1);
        Country country2 = Country.builder()
                .qualityOfLiveIndex(QualityOfLiveIndex.GOOD)
                .name("usa")
                .build();
        countryRepository.save(country2);

        Country country3 = Country.builder()
                .qualityOfLiveIndex(QualityOfLiveIndex.EXCELLENT)
                .name("uk")
                .build();
        countryRepository.save(country3);

        Company company1 = Company.builder()
                .country(country1)
                .name("NIC")
                .build();
        companyRepository.save(company1);

        Company company2 = Company.builder()
                .country(country2)
                .name("Google")
                .build();
        companyRepository.save(company2);

        Company company3 = Company.builder()
                .country(country2)
                .name("IBM")
                .build();
        companyRepository.save(company3);



        Date date = new Date();
        date.setYear(1993);
        Date date2 = new Date();
        date.setYear(1995);

        Employee employee1 = Employee.builder()
                .birthday(date)
                .firstWorkDay(date2)
                .build();
        employeeRepository.save(employee1);

        Employee employee2 = Employee.builder()
                .birthday(date)
                .firstWorkDay(date2)
                .build();
        employeeRepository.save(employee2);

        Vacancy vacancy3 = Vacancy.builder()
                .company(company1)
                .dateClosed(date)
                .dateOpened(date2)
                .employee(employee1)
                .name("dgfsg")
                .build();
        vacancyRepository.save(vacancy3);
        vacancy3 = Vacancy.builder()
                .company(company2)
                .dateClosed(date)
                .dateOpened(date2)
                .employee(employee2)
                .name("sfgsfds")
                .build();
        vacancyRepository.save(vacancy3);
        vacancy3 = Vacancy.builder()
                .company(company1)
                .dateClosed(date)
                .dateOpened(date2)
                .employee(employee1)
                .name("sfhhhds")
                .build();
        vacancyRepository.save(vacancy3);

        return new ResponseEntity(HttpStatus.OK);
    }
}
