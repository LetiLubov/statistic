package com.spring.app.repos;

import com.spring.app.domain.Employee;
import org.springframework.data.repository.CrudRepository;

import java.util.Date;
import java.util.List;

public interface EmployeeRepository extends CrudRepository<Employee, Long> {

    List<Employee> findByBirthday(Date birthday);


}