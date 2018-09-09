package com.spring.app.domain.dao;

import com.spring.app.domain.Employee;
import org.springframework.stereotype.Repository;

@Repository
public class EmployeeDAO extends GenericDaoImpl<Employee> {

    public EmployeeDAO(){
        setPersistentClass(Employee.class);
    }
}
