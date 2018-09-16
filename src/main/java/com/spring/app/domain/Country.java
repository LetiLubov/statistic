package com.spring.app.domain;

import com.spring.app.EconomyLevel;
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
                                "           AND company.date_opened <= :toDate " +
                                "           AND (company.date_closed ISNULL OR company.date_closed >= :fromDate)) " +
                                "INNER JOIN vacancy ON (company.id = vacancy.company_id AND vacancy.opened = TRUE " +
                                "           AND vacancy.date_opened  >= :fromDate " +
                                "           AND (vacancy.date_closed ISNULL OR vacancy.date_closed >= :toDate))" +
                                "INNER JOIN employee ON vacancy.employee_id = employee.id " +
                                "WHERE country.name = :countryName"),
                @NamedNativeQuery(
                        name = "AVG_EXPERIENCE",
                        query = "SELECT AVG((cast(extract(year FROM cast (:toDate AS DATE)) AS int)) -  employee.career_start_year) " +
                                "FROM country " +
                                "INNER JOIN company ON (country.id = company.country_id " +
                                "           AND company.date_opened <= :toDate " +
                                "           AND (company.date_closed ISNULL OR company.date_closed >= :fromDate)) " +
                                "INNER JOIN vacancy ON (company.id = vacancy.company_id AND vacancy.opened = TRUE " +
                                "           AND vacancy.date_opened  >= :fromDate " +
                                "           AND (vacancy.date_closed ISNULL OR vacancy.date_closed >= :toDate))" +
                                "INNER JOIN employee ON vacancy.employee_id = employee.id " +
                                "WHERE country.name = :countryName"),
                @NamedNativeQuery(
                        name = "AVG_AGE",
                        query = "SELECT AVG((cast(extract(year FROM cast (:toDate AS DATE)) AS int)) -  employee.birth_year) " +
                                "FROM country " +
                                "INNER JOIN company ON (country.id = company.country_id " +
                                "           AND company.date_opened <= :toDate " +
                                "           AND (company.date_closed ISNULL OR company.date_closed >= :fromDate)) " +
                                "INNER JOIN vacancy ON (company.id = vacancy.company_id AND vacancy.opened = TRUE " +
                                "           AND vacancy.date_opened  >= :fromDate " +
                                "           AND (vacancy.date_closed ISNULL OR vacancy.date_closed >= :toDate))" +
                                "INNER JOIN employee ON vacancy.employee_id = employee.id " +
                                "WHERE country.name = :countryName"),
                @NamedNativeQuery(
                        name = "AVG_NUMBER_OF_EMPLOYEES",
                        query = "SELECT AVG (count_table.number_of_emp)" +
                                "FROM(" +
                                "    SELECT COUNT(vacancy.id) as number_of_emp" +
                                "    FROM company JOIN country ON (country.id = company.country_id " +
                                "                              AND company.date_opened <= :toDate " +
                                "                              AND (company.date_closed ISNULL OR company.date_closed >= :fromDate)) " +
                                "    JOIN vacancy ON (company.id = vacancy.company_id AND vacancy.opened = TRUE " +
                                "                              AND vacancy.date_opened  >= :fromDate " +
                                "                              AND (vacancy.date_closed ISNULL OR vacancy.date_closed >= :toDate))" +
                                "    WHERE country.name = :countryName " +
                                "    GROUP BY company.name) " +
                                "AS count_table"
                )
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
    public static String AVG_NUMBER_OF_EMPLOYEES = "AVG_NUMBER_OF_EMPLOYEES";
    public static String AVG_AGE = "AVG_AGE";

    @Column(name = "NAME")
    private String name;

    @Column(name = "LIVE_INDEX")
    @Enumerated(EnumType.STRING)
    private EconomyLevel economyLevel;
}




