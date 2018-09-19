package com.spring.app.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

/**
 * Data transfer object for storage info about average indicators for developers in the country
 *
 * @author Lyubov Ruzanova
 */
@Getter
@Setter
@NoArgsConstructor
public class EmployeeProfileDTO implements Serializable {
    private double salary;
    private int age;
    private int experience;
    private int numberOfEmployees;

    public EmployeeProfileDTO(double salary, int age, int experience, int numberOfEmployees) {
        this.salary = salary;
        this.age = age;
        this.experience = experience;
        this.numberOfEmployees = numberOfEmployees;
    }
}
