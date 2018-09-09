package com.spring.app.domain;


import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.NamedNativeQueries;
import javax.persistence.NamedNativeQuery;
import java.util.Date;

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

    @Column(name = "BIRTHDAY_YEAR")
    private int birthdayYear;
    @Column(name = "YEAR_OF_FIRST_WORK_DAY")
    private int yearOfFirstWorkDay;
}
