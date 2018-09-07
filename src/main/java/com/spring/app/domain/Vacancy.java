package com.spring.app.domain;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

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
