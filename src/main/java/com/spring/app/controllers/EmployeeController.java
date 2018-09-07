package com.spring.app.controllers;

import com.spring.app.Constants;
import com.spring.app.domain.Employee;
import com.spring.app.repos.EmployeeRepository;
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
import java.util.Locale;
import java.util.Map;

/**
 * EmployeeController
 * All activities with employees
 * @author lyubov
 */
@RestController("employees")
public class EmployeeController {
    @Autowired
    private EmployeeRepository employeeRepository;

    @GetMapping
    public ResponseEntity<Iterable<Employee>> listAllEmployees() {
        Iterable<Employee> employees = employeeRepository.findAll();
        return new ResponseEntity<>(employees, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Employee> addEmployee(@RequestParam String birthday, @RequestParam String firstWorkDay) {
        try {
            Employee employee = new Employee(Constants.dateFormat.parse(birthday), Constants.dateFormat.parse(firstWorkDay));
            employeeRepository.save(employee);
            return new ResponseEntity<>(employee, HttpStatus.OK);
        } catch (ParseException e) {
            e.printStackTrace();
            //todo remove stack to log! and find what response should i return if smth goes wrong
            return new ResponseEntity<>( HttpStatus.BAD_REQUEST);
        }
    }
}