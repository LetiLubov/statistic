package com.spring.app.services;

import com.spring.app.domain.Employee;
import com.spring.app.domain.dao.EmployeeDAO;
import com.spring.app.dto.EmployeeDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EmployeeService {
    @Autowired
    private EmployeeDAO repository;

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
