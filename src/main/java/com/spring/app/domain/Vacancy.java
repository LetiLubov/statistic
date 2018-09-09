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
 * @author Lyubov Ruzanova
 */

@NamedNativeQueries({
        @NamedNativeQuery(name = "ALL_VACANCIES", query = "SELECT * FROM country")
})
@Entity
@NoArgsConstructor
@EqualsAndHashCode(exclude = "VACANCY_ID")
public class Vacancy extends BaseEntity {

    public static String ALL_VACANCIES = "ALL_VACANCIES";

    @Getter
    @Setter
    @Column(name = "VACANCY_NAME")
    private String name;

    @Getter
    @Setter
    @Column(name = "SALARY")
    private float salary;

    @Getter
    @Setter
    @Column(name = "OPENED")
    private boolean opened;

    @OneToOne
    @JoinColumn(name = "employee_id")
    private Employee employee;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "company_id")
    private Company company;

    @Column(name = "DATE_OPENED")
    private Date dateOpened;

    @Column(name = "DATE_CLOSED")
    private Date dateClosed;

    public Vacancy(String name, float salary, Date dateOpened) {
        this.name = name;
        this.salary = salary;
        this.dateOpened = dateOpened;
    }

    public Employee getEmployee() {
        return new Employee(this.employee);
    }

    public void setEmployee(Employee employee) {
        this.employee = new Employee(employee);
    }

    public Company getCompany() {
        return new Company(this.company);
    }

    public void setCompany(Company company) {
        this.company = new Company(company);
    }

    public Date getDateOpened() {
        return (Date) dateOpened.clone();
    }

    public void setDateOpened(Date dateOpened) {
        this.dateOpened = (Date) dateOpened.clone();
    }

    public Date getDateClosed() {
        return (Date) dateClosed.clone();
    }

    public void setDateClosed(Date dateClosed) {
        this.dateClosed = (Date) dateClosed.clone();
    }
}
