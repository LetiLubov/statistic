package com.spring.app.controllers;

import com.spring.app.domain.Employee;
import com.spring.app.dto.EmployeeDTO;
import com.spring.app.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * EmployeeController
 * All activities with employees
 * @author lyubov
 */
@RestController
@RequestMapping("/employees")
public class EmployeeController {
    private EmployeeService service;

    public EmployeeController(@Autowired EmployeeService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<EmployeeDTO>> getList() {
        return new ResponseEntity<>(service.getList(), HttpStatus.OK);
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Employee> add(@RequestBody EmployeeDTO dto) {
        Employee employee = dto.toEntity();
        service.save(employee);
        return new ResponseEntity<>(employee, HttpStatus.OK);
    }
}