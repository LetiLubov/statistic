package com.spring.app.controllers;

import com.spring.app.domain.Employee;
import com.spring.app.repos.EmployeeRepository;
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
public class EmployeeController {
    @Autowired
    private EmployeeRepository employeeRepository;

    @GetMapping("employees")
    public String main(Map<String, Object> model) {
        Iterable<Employee> messages = employeeRepository.findAll();

        model.put("employees", messages);

        return "employee";
    }

    @PostMapping("employees")
    public String add(@RequestParam String birthday, @RequestParam String firstWorkDay, Map<String, Object> model) {
        DateFormat df = new SimpleDateFormat("yyyy-mm-dd", Locale.ENGLISH);
        try {
            Employee employee = new Employee(df.parse(birthday), df.parse(firstWorkDay));
            employeeRepository.save(employee);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        Iterable<Employee> employees = employeeRepository.findAll();

        model.put("employees", employees);

        return "employee";
    }

    @PostMapping("employees/filter")
    public String filter(@RequestParam String filter, Map<String, Object> model) {
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
            employees = employeeRepository.findAll();
        }



        model.put("employees", employees);

        return "employee";
    }
}