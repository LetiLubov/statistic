package com.spring.app.dto;

import com.spring.app.domain.Employee;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

/**
 * EmployeeDTO
 * Data layer for storage info about employee
 * @author Lyubov Ruzanova
 */
@Getter
@Setter
@NoArgsConstructor
public class EmployeeDTO implements IWrapper<Employee, EmployeeDTO>{
    private Date birthday;
    private Date firstWorkDay;

    private EmployeeDTO(Employee employee){
        this.birthday = employee.getBirthday();
        this.firstWorkDay = employee.getFirstWorkDay();
    }

    @Override
    public EmployeeDTO fromEntity(Employee entity) {
        return new EmployeeDTO(entity);
    }

    @Override
    public Employee toEntity() {
        Employee employee = new Employee();
        employee.setBirthday(this.birthday);
        employee.setFirstWorkDay(this.firstWorkDay);
        return employee;
    }
}
