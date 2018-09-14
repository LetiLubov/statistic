package com.spring.app.controllers;

import com.spring.app.domain.Employee;
import com.spring.app.dto.EmployeeDTO;
import com.spring.app.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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
    private EmployeeService service;

    public EmployeeController(@Autowired EmployeeService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<EmployeeDTO>> getList() {
        return new ResponseEntity<>(service.getList(), HttpStatus.OK);
    }

    @PostMapping
    @ResponseStatus(value = HttpStatus.OK)
    public void add(@RequestBody EmployeeDTO dto) {
        Employee employee = dto.toEntity();
        service.save(employee);
    }
}