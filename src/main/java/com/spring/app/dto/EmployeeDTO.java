package com.spring.app.dto;

import com.spring.app.domain.Employee;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Data transfer object for storage info about employee
 *
 * @author Lyubov Ruzanova
 */
@Getter
@Setter
@NoArgsConstructor
public class EmployeeDTO implements IWrapper<Employee, EmployeeDTO>{
    private int birthYear;
    private int careerStartYear;

    /**
     * Constructor for copying the Employee object to the EmployeeDTO object
     * @param employee - storage for an entity from a DB
     */
    private EmployeeDTO(Employee employee){
        this.birthYear = employee.getBirthYear();
        this.careerStartYear = employee.getCareerStartYear();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public EmployeeDTO fromEntity(Employee entity) {
        return new EmployeeDTO(entity);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Employee toEntity() {
        Employee employee = new Employee();
        employee.setBirthYear(this.birthYear);
        employee.setCareerStartYear(this.careerStartYear);
        return employee;
    }
}
