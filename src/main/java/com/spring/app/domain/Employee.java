package com.spring.app.domain;

import lombok.*;

import javax.persistence.*;
import java.util.Date;

/**
 * Employee
 * @author Lyubov Ruzanova
 */
@Entity
@NoArgsConstructor
@EqualsAndHashCode(exclude = "EMPLOYEE_ID")
public class Employee extends BaseEntity{

    @Column(name = "BIRTHDAY")
    private Date birthday;
    @Column(name = "FIRST_WORK_DAY")
    private Date firstWorkDay;

    public Employee(Date birthday, Date firstWorkDay) {
        this.birthday = birthday;
        this.firstWorkDay = firstWorkDay;
    }
}
