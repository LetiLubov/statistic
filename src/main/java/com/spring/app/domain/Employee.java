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

    @Column(name = "BIRTHDAY")
    private Date birthday;
    @Column(name = "FIRST_WORK_DAY")
    private Date firstWorkDay;
}
