package com.spring.app.dto;

import lombok.AllArgsConstructor;
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
@AllArgsConstructor
public class EmployeeProfileDTO implements Serializable {
    private double salary;
    private int age;
    private int experience;
    private int numberOfEmployees;
}
