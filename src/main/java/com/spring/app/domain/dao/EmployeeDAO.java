package com.spring.app.domain.dao;

import com.spring.app.domain.Employee;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EmployeeDAO extends GenericDaoImpl<Employee> {
    public List<Employee> getAllEmployees() {
        return em.createNativeQuery(Employee.ALL_EMPLOYEES)
                .getResultList();
    }
}
