package com.spring.app.domain;


import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.NamedNativeQueries;
import javax.persistence.NamedNativeQuery;
import java.util.Date;

/**
 * Employee
 * @author Lyubov Ruzanova
 */

@NamedNativeQueries({
        @NamedNativeQuery(name = "ALL_EMPLOYEES", query = "SELECT * FROM country")
})
@Entity
@NoArgsConstructor
@EqualsAndHashCode(exclude = "EMPLOYEE_ID")
public class Employee extends BaseEntity{
    public static String ALL_EMPLOYEES = "ALL_EMPLOYEES";

    @Column(name = "BIRTHDAY")
    private Date birthday;
    @Column(name = "FIRST_WORK_DAY")
    private Date firstWorkDay;

    public Employee(Date birthday, Date firstWorkDay) {
        this.birthday = birthday;
        this.firstWorkDay = firstWorkDay;
    }

    public Employee(Employee employee){
        this.id = employee.id;
        this.birthday = employee.getBirthday();
        this.firstWorkDay = employee.getFirstWorkDay();
    }

    public Date getBirthday() {
        return (Date) this.birthday.clone();
    }

    public void setBirthday(Date birthday) {
        this.birthday = (Date) birthday.clone();
    }

    public Date getFirstWorkDay() {
        return (Date) this.firstWorkDay.clone();
    }

    public void setFirstWorkDay(Date firstWorkDay) {
        this.firstWorkDay = (Date) firstWorkDay.clone();
    }

}
