package com.spring.app.controllers;

import com.spring.app.domain.Employee;
import com.spring.app.domain.Vacancy;
import com.spring.app.repos.VacancyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Map;

@Controller
public class VacancyController {
    @Autowired
    private VacancyRepository vacancyRepository;

    @GetMapping("vacancies")
    public String main(Map<String, Object> model) {
        Iterable<Vacancy> messages = vacancyRepository.findAll();

        model.put("vacancies", messages);

        return "vacancy";
    }

    @PostMapping("vacancies")
    public String add(@RequestParam String name, @RequestParam String sSalary, @RequestParam String sDate, Map<String, Object> model) {
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


        Iterable<Vacancy> vacancies = vacancyRepository.findAll();

        model.put("vacancies", vacancies);

        return "vacancy";
    }

    @GetMapping("vacancies/filter")
    public String filter(@RequestParam String filter, Map<String, Object> model) {
        Iterable<Vacancy> vacancies;

        if (filter != null && !filter.isEmpty() ) {
            vacancies = vacancyRepository.findByName(filter);
        } else {
            vacancies = vacancyRepository.findAll();
        }

        model.put("vacancies", vacancies);

        return "vacancy";
    }
}
