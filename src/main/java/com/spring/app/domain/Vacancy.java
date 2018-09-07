package com.spring.app.domain;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * Vacancy
 * Has a one-directional relation bound to company
 *                                      and to employee
 * Has a boolean field opened and fields to registry date of employee start his work and when he retired.
 * This options work together to show different situation:
 * the first one: The Vacancy is exist, but no one has responded it. Equivalent for flag is true and null dates
 * the second: employee was found, so flag is still true, and we had dateOpened, dateClosed == null
 * the last one: the closed vacancy, flag is turned to false and we have two dates dateOpened and dateClosed, that not null
 *
 * @author lyubov
 */
@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(exclude = "vacancy_id")
public class Vacancy implements Serializable {
    @Id
    @Column(name = "vacancy_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private float salary;
    private boolean opened;

    @OneToOne
    @JoinColumn(name = "employee_id")
    private Employee employee;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "company_id")
    private Company company;
//
//    private long companyId;

    private Date dateOpened;
    private Date dateClosed;

    public Vacancy(String name, float salary, Date dateOpened) {
        this.name = name;
        this.salary = salary;
        this.dateOpened = dateOpened;
    }
}
