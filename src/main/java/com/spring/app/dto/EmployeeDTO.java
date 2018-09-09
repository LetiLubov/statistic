package com.spring.app.dto;

import com.spring.app.domain.Employee;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * EmployeeDTO
 * Data layer for storage info about employee
 * @author Lyubov Ruzanova
 */
@Getter
@Setter
@NoArgsConstructor
public class EmployeeDTO implements IWrapper<Employee, EmployeeDTO>{
    private int birthdayYear;
    private int YearOfFirstWorkDay;

    private EmployeeDTO(Employee employee){
        this.birthdayYear = employee.getBirthdayYear();
        this.YearOfFirstWorkDay = employee.getYearOfFirstWorkDay();
    }

    @Override
    public EmployeeDTO fromEntity(Employee entity) {
        return new EmployeeDTO(entity);
    }

    @Override
    public Employee toEntity() {
        Employee employee = new Employee();
        employee.setBirthdayYear(this.birthdayYear);
        employee.setYearOfFirstWorkDay(this.YearOfFirstWorkDay);
        return employee;
    }
}
