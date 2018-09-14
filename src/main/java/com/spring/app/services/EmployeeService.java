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
 * Save new entry to db
 * Get list of all entries from db
 *
 * @author Lyubov Ruzanova
 */
@Service
public class EmployeeService {

    private EmployeeDAO repository;

    public EmployeeService(@Autowired EmployeeDAO repository) {
        this.repository = repository;
    }

    public List<EmployeeDTO> getList(){
        return repository
                .findAll()
                .stream()
                .map(c -> new EmployeeDTO().fromEntity(c))
                .collect(Collectors.toList());
    }

    public void save(Employee employee){
        repository.create(employee);
    }

}
