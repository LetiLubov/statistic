package com.spring.app;

import com.spring.app.domain.Company;
import com.spring.app.domain.Country;
import com.spring.app.domain.Employee;
import com.spring.app.domain.Vacancy;
import com.spring.app.repos.CompanyRepository;
import com.spring.app.repos.CountryRepository;
import com.spring.app.repos.EmployeeRepository;
import com.spring.app.repos.VacancyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;

import java.util.Date;

@SpringBootApplication
//@Controller
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
//        addSmthInDB();
    }

    @Autowired
    private static VacancyRepository vacancyRepository;
    @Autowired
    private static CompanyRepository companyRepository;
    @Autowired
    private static CountryRepository countryRepository;
    @Autowired
    private static EmployeeRepository employeeRepository;
    private static void addSmthInDB(){
        Country country1 = Country.builder()
                .countryLevel(CountryLevel.GOOD)
                .name("rus")
                .build();
        Country country2 = Country.builder()
                .countryLevel(CountryLevel.GOOD)
                .name("usa")
                .build();
        Country country3 = Country.builder()
                .countryLevel(CountryLevel.EXCELENT)
                .name("uk")
                .build();

        Company company1 = Company.builder()
                .country(country1)
                .name("NIC")
                .build();
        Company company2 = Company.builder()
                .country(country2)
                .name("Google")
                .build();
        Company company3 = Company.builder()
                .country(country2)
                .name("IBM")
                .build();



        Date date = new Date();
        date.setYear(1993);
        Date date2 = new Date();
        date.setYear(1995);

        Employee employee1 = Employee.builder()
                .birthday(date)
                .firstWorkDay(date2)
                .build();
        Employee employee2 = Employee.builder()
                .birthday(date)
                .firstWorkDay(date2)
                .build();

        Vacancy vacancy = Vacancy.builder()
                .company(company1)
                .dateClosed(date)
                .dateOpened(date2)
                .employee(employee1)
                .name("dgfsg")
                .build();
        vacancyRepository.save(vacancy);
        vacancy = Vacancy.builder()
                .company(company2)
                .dateClosed(date)
                .dateOpened(date2)
                .employee(employee2)
                .name("sfgsfds")
                .build();
        vacancyRepository.save(vacancy);
        vacancy = Vacancy.builder()
                .company(company1)
                .dateClosed(date)
                .dateOpened(date2)
                .employee(employee1)
                .name("sfhhhds")
                .build();
        vacancyRepository.save(vacancy);
    }
}