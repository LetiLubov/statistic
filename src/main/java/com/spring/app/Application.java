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
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}