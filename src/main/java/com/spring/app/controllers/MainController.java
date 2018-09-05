package com.spring.app.controllers;

import com.spring.app.CountryLevel;
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
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.sql.Time;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Set;

@Controller
public class MainController {
    @GetMapping
    public String main(Map<String, Object> model) {

        return "home";
    }

    @Autowired
    private VacancyRepository vacancyRepository;
    @Autowired
    private CompanyRepository companyRepository;
    @Autowired
    private CountryRepository countryRepository;
    @Autowired
    private EmployeeRepository employeeRepository;

    @PostMapping("home/newDBinit")
    public ResponseEntity filter(Map<String, Object> model){
        Country country1 = Country.builder()
                .countryLevel(CountryLevel.GOOD)
                .name("rus")
                .build();

        countryRepository.save(country1);
        Country country2 = Country.builder()
                .countryLevel(CountryLevel.GOOD)
                .name("usa")
                .build();
        countryRepository.save(country2);

        Country country3 = Country.builder()
                .countryLevel(CountryLevel.EXCELENT)
                .name("uk")
                .build();
        countryRepository.save(country3);

        Company company1 = Company.builder()
//                .country(country1)
                .name("NIC")
                .build();
        companyRepository.save(company1);

        Company company2 = Company.builder()
//                .country(country2)
                .name("Google")
                .build();
        companyRepository.save(company2);

        Company company3 = Company.builder()
//                .country(country2)
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
//                .company(company1)
                .dateClosed(date)
                .dateOpened(date2)
                .employee(employee1)
                .name("dgfsg")
                .build();
        vacancyRepository.save(vacancy3);
        vacancy3 = Vacancy.builder()
//                .company(company2)
                .dateClosed(date)
                .dateOpened(date2)
                .employee(employee2)
                .name("sfgsfds")
                .build();
        vacancyRepository.save(vacancy3);
        vacancy3 = Vacancy.builder()
//                .company(company1)
                .dateClosed(date)
                .dateOpened(date2)
                .employee(employee1)
                .name("sfhhhds")
                .build();
        vacancyRepository.save(vacancy3);

        return new ResponseEntity(HttpStatus.OK);
    }

    @GetMapping("home/findAverageAgeByCountry")
    public ResponseEntity<Integer> filter(@RequestParam String country, Map<String, Object> model) {

        Integer age = 0;

        Employee employee = employeeRepository.findById(1).get(0);
        Country country1 = countryRepository.findByName("rus").get(0);
        Company company = companyRepository.findByCountry(country1).get(0);
        Vacancy vacancy = vacancyRepository.findByCompany(company).get(0);

        if (country != null && !country.isEmpty() ) {
            Country countryModel =  countryRepository.findByName(country).get(0);
            System.out.println();
//            int totalAge = (int) countryModel.getCompanies().stream()
//                    .flatMap(company -> company.getVacancy().stream())
//                    .map(vacancy -> (int)(new Date().getTime() - vacancy.getEmployee().getBirthday().getTime())/ 1000/ 60/ 60/ 24/ 365)
//                    .reduce(0, (x, y) -> x+y);
//            int count = (int) countryModel.getCompanies().stream()
//                    .flatMap(company -> company.getVacancy().stream())
//                    .map(vacancy -> vacancy.getEmployee())
//                    .count();

//
//            System.out.println(totalAge );
//            System.out.println( count);
//            System.out.println(totalAge / count);
        } else {
//            vacancies = vacancyRepository.findAll();
        }


        return new ResponseEntity<>(age, HttpStatus.OK);
    }
}
