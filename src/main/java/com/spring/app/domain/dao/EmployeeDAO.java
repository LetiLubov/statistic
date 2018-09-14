package com.spring.app.domain.dao;

import com.spring.app.domain.Employee;
import org.springframework.stereotype.Repository;

/**
 * DAO for Employee
 * Has default features
 * {@inheritDoc}
 *
 * @author Lyubov Ruzanova
 */
@Repository
public class EmployeeDAO extends GenericDaoImpl<Employee> {

    /**
     * Set Employee.class as a persistent class
     */
    public EmployeeDAO(){
        setPersistentClass(Employee.class);
    }
}
