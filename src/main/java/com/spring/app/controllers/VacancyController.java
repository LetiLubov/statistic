package com.spring.app.controllers;

import com.spring.app.domain.Employee;
import com.spring.app.domain.Vacancy;
import com.spring.app.repos.VacancyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Map;

/**
 * VacancyController
 * All activities with vacancies
 * @author lyubov
 */
@RestController("vacancies")
public class VacancyController {
    @Autowired
    private VacancyRepository vacancyRepository;

    @GetMapping
    public ResponseEntity<Iterable<Vacancy>> listAllVacancies() {
        Iterable<Vacancy> vacancies = vacancyRepository.findAll();
        return new ResponseEntity<>(vacancies, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Vacancy> add(@RequestParam String name, @RequestParam String sSalary, @RequestParam String sDate) {
        DateFormat df = new SimpleDateFormat("yyyy-mm-dd", Locale.ENGLISH);
        Date date = new Date();
        try {
            date = df.parse(sDate);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        float salary = Float.parseFloat(sSalary);
        Vacancy vacancy = new Vacancy(name, salary, date);
            vacancyRepository.save(vacancy);
        return new ResponseEntity<>(vacancy, HttpStatus.OK);
    }
}
