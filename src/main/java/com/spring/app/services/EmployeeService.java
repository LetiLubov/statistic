package com.spring.app.services;

import com.spring.app.domain.Employee;
import com.spring.app.domain.dao.EmployeeDAO;
import com.spring.app.dto.EmployeeDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Service for employee
 *
 * @author Lyubov Ruzanova
 */
@Service
public class EmployeeService {

    private final EmployeeDAO repository;

    /**
     * Injects a employee repository
     * @param repository - employee repository
     */
    public EmployeeService(@Autowired EmployeeDAO repository) {
        this.repository = repository;
    }

    /**
     * Gets all employees from repository and convert them to EmployeeDTO format
     * @return list of employees
     */
    public List<EmployeeDTO> getList(){
        return repository
                .findAll()
                .stream()
                .map(c -> new EmployeeDTO().fromEntity(c))
                .collect(Collectors.toList());
    }

    /**
     * Saves a new employee to DB
     * @param employee - the employee to save in DB
     */
    public void save(Employee employee){
        repository.create(employee);
    }

}
