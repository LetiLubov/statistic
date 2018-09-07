package com.spring.app.controllers;

import com.spring.app.domain.Employee;
import com.spring.app.repos.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Locale;
import java.util.Map;

/**
 * EmployeeController
 *
 * @author lyubov
 */
@Controller
public class EmployeeController {
    @Autowired
    private EmployeeRepository employeeRepository;

    @GetMapping("employees")
    public ResponseEntity<Iterable<Employee>> main(Map<String, Object> model) {
        Iterable<Employee> employees = employeeRepository.findAll();
        return new ResponseEntity<>(employees, HttpStatus.OK);
    }

    @PostMapping("employees")
    public ResponseEntity<Employee> add(@RequestParam String birthday, @RequestParam String firstWorkDay, Map<String, Object> model) {
        DateFormat df = new SimpleDateFormat("yyyy-mm-dd", Locale.ENGLISH);
        try {
            Employee employee = new Employee(df.parse(birthday), df.parse(firstWorkDay));
            employeeRepository.save(employee);
            return new ResponseEntity<>(employee, HttpStatus.OK);
        } catch (ParseException e) {
            e.printStackTrace();
            //todo remove stack to log! and find what response should i return if smth goes wrong
            return new ResponseEntity<>( HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("employees/filter")
    public ResponseEntity<Iterable<Employee>> filter(@RequestParam String filter, Map<String, Object> model) {
        Iterable<Employee> employees;
        DateFormat df = new SimpleDateFormat("yyyy-mm-dd", Locale.ENGLISH);
        try {
            if (filter != null && !filter.isEmpty()) {
                employees = employeeRepository.findByBirthday((df.parse(filter)));
            } else {
                employees = employeeRepository.findAll();
            }
        } catch (ParseException e) {
            e.printStackTrace();
            //todo remove stack to log! and find what response should i return if smth goes wrong
            return new ResponseEntity<>( HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(employees, HttpStatus.OK);
    }
}