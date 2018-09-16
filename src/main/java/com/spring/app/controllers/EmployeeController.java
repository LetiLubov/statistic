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
 * Rest controller for an employees
 * Provide all actions with employees
 *
 * @author Lyubov Ruzanova
 */
@RestController
@RequestMapping(value = "/employees", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
public class EmployeeController {
    private final EmployeeService service;

    /**
     * Inject a employee service
     * @param service - employee service
     */
    public EmployeeController(@Autowired EmployeeService service) {
        this.service = service;
    }

    /**
     * Send a request to the service to get all employees
     * @return list of employees
     */
    @GetMapping
    @ResponseBody
    public ResponseEntity<List<EmployeeDTO>> getList() {
        return ResponseEntity.ok(service.getList());
    }

    /**
     * Send a request to the service to save a new instance
     * @param dto - employee info
     * @return employeeDTO object
     */
    @PostMapping
    @ResponseBody
    public ResponseEntity<EmployeeDTO> add(@RequestBody EmployeeDTO dto) {
        Employee employee = dto.toEntity();
        service.save(employee);
        return ResponseEntity.ok(dto);
    }
}