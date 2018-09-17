package com.spring.app.domain;

import com.spring.app.EconomicLevel;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

/**
 * Country
 * Has an enum field that contains a living level
 *
 * @author Lyubov Ruzanova
 */

@NamedNativeQueries(
        {
                @NamedNativeQuery(
                        name = "MEAN_SALARY",
                        query = "SELECT AVG(vacancy.salary) " +
                                "FROM country " +
                                "INNER JOIN company ON (country.id = company.country_id " +
                                "           AND company.date_opened <= :to_date " +
                                "           AND (company.date_closed ISNULL OR company.date_closed >= :from_date)) " +
                                "INNER JOIN vacancy ON (company.id = vacancy.company_id AND vacancy.opened = TRUE " +
                                "           AND vacancy.date_opened  >= :from_date " +
                                "           AND (vacancy.date_closed ISNULL OR vacancy.date_closed >= :to_date))" +
                                "INNER JOIN employee ON vacancy.employee_id = employee.id " +
                                "WHERE country.name = :country_name"),
                @NamedNativeQuery(
                        name = "AVG_EXPERIENCE",
                        query = "SELECT AVG((cast(extract(year FROM cast (:to_date AS DATE)) AS int)) -  employee.career_start_year) " +
                                "FROM country " +
                                "INNER JOIN company ON (country.id = company.country_id " +
                                "           AND company.date_opened <= :to_date " +
                                "           AND (company.date_closed ISNULL OR company.date_closed >= :from_date)) " +
                                "INNER JOIN vacancy ON (company.id = vacancy.company_id AND vacancy.opened = TRUE " +
                                "           AND vacancy.date_opened  >= :from_date " +
                                "           AND (vacancy.date_closed ISNULL OR vacancy.date_closed >= :to_date))" +
                                "INNER JOIN employee ON vacancy.employee_id = employee.id " +
                                "WHERE country.name = :country_name"),
                @NamedNativeQuery(
                        name = "AVG_AGE",
                        query = "SELECT AVG((cast(extract(year FROM cast (:to_date AS DATE)) AS int)) -  employee.birth_year) " +
                                "FROM country " +
                                "INNER JOIN company ON (country.id = company.country_id " +
                                "           AND company.date_opened <= :to_date " +
                                "           AND (company.date_closed ISNULL OR company.date_closed >= :from_date)) " +
                                "INNER JOIN vacancy ON (company.id = vacancy.company_id AND vacancy.opened = TRUE " +
                                "           AND vacancy.date_opened  >= :from_date " +
                                "           AND (vacancy.date_closed ISNULL OR vacancy.date_closed >= :to_date))" +
                                "INNER JOIN employee ON vacancy.employee_id = employee.id " +
                                "WHERE country.name = :country_name"),
                @NamedNativeQuery(
                        name = "AVG_NUM_OF_EMP_IN_COMPANIES",
                        query = "SELECT AVG (count_table.number_of_emp)" +
                                "FROM(" +
                                "    SELECT COUNT(vacancy.id) as number_of_emp" +
                                "    FROM company JOIN country ON (country.id = company.country_id " +
                                "                              AND company.date_opened <= :to_date " +
                                "                              AND (company.date_closed ISNULL OR company.date_closed >= :from_date)) " +
                                "    JOIN vacancy ON (company.id = vacancy.company_id AND vacancy.opened = TRUE " +
                                "                              AND vacancy.date_opened  >= :from_date " +
                                "                              AND (vacancy.date_closed ISNULL OR vacancy.date_closed >= :to_date))" +
                                "    WHERE country.name = :country_name " +
                                "    GROUP BY company.name) " +
                                "AS count_table"),

                @NamedNativeQuery(
                        name = "COUNTRY_PROFILES",
                        query = "SELECT " +
                                "       country_name_field       AS country, " +
                                "       AVG(avgSalary)           AS salary," +
                                "       AVG(avgAge)              AS age, " +
                                "       AVG(avgExp)              AS experience, " +
                                "       AVG(number_of_employees) AS number_of_employees " +
                                "FROM (SELECT COUNT(country.id)                                                                          AS number_of_employees, " +
                                "             country.name                                                                               AS country_name_field, " +
                                "             AVG(vacancy.salary)                                                                        AS avgSalary, " +
                                "             AVG((cast(extract(year FROM cast(:to_date AS DATE)) AS int)) - employee.birth_year)        AS avgAge, " +
                                "             AVG((cast(extract(year FROM cast(:to_date AS DATE)) AS int)) - employee.career_start_year) AS avgExp " +
                                "      FROM country " +
                                "             INNER JOIN company ON (country.id = company.country_id " +
                                "                                      AND company.date_opened <= :to_date " +
                                "                                      AND (company.date_closed ISNULL OR company.date_closed >= :from_date)) " +
                                "             INNER JOIN vacancy ON (company.id = vacancy.company_id " +
                                "                                      AND vacancy.opened = TRUE " +
                                "                                      AND vacancy.date_opened >= :from_date " +
                                "                                      AND (vacancy.date_closed ISNULL OR vacancy.date_closed >= :to_date)) " +
                                "             INNER JOIN employee ON vacancy.employee_id = employee.id " +
                                "      GROUP BY company.name, country.name) AS country_comp " +
                                "GROUP BY country_name_field")
        }
)
@Entity
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class Country extends BaseEntity {
    public static String MEAN_SALARY = "MEAN_SALARY";
    public static String AVG_EXPERIENCE = "AVG_EXPERIENCE";
    public static String AVG_NUM_OF_EMP_IN_COMPANIES = "AVG_NUM_OF_EMP_IN_COMPANIES";
    public static String AVG_AGE = "AVG_AGE";
    public static String COUNTRY_PROFILES = "COUNTRY_PROFILES";

    @Column(name = "NAME")
    private String name;

    @Column(name = "LIVE_INDEX")
    @Enumerated(EnumType.STRING)
    private EconomicLevel economicLevel;
}




