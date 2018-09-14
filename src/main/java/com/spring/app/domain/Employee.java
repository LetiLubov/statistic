package com.spring.app.domain;


import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;

/**
 * Employee
 * @author Lyubov Ruzanova
 */

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(exclude = "EMPLOYEE_ID")
public class Employee extends BaseEntity{

    @Column(name = "BIRTH_YEAR")
    private int birthYear;
    @Column(name = "CAREER_START_YEAR")
    private int careerStartYear;
}
