package com.spring.app.repos;

import com.spring.app.domain.Employee;
import org.springframework.data.repository.CrudRepository;

import java.util.Date;
import java.util.List;

/**
 * EmployeeRepository
 * The most common CRUD-requests
 * @author lyubov
 */
public interface EmployeeRepository extends CrudRepository<Employee, Long> {

    List<Employee> findByBirthday(Date birthday);


}