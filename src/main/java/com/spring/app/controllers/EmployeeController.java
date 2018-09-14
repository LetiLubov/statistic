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
 * @author Lyubov Ruzanova
 */
@ResponseBody
@RestController
@RequestMapping("/employees")
public class EmployeeController {
    private final EmployeeService service;

    public EmployeeController(@Autowired EmployeeService service) {
        this.service = service;
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<EmployeeDTO>> getList() {
        return new ResponseEntity<>(service.getList(), HttpStatus.OK);
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<EmployeeDTO> add(@RequestBody EmployeeDTO dto) {
        Employee employee = dto.toEntity();
        service.save(employee);
        return new ResponseEntity<>(dto, HttpStatus.OK);
    }
}