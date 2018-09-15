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
                        query = "SELECT AVG(vacancy.salary) FROM country INNER JOIN company " +
                                "ON country.id = company.country_id INNER JOIN vacancy ON company.id = vacancy.company_id " +
                                "WHERE country.name = ?1 AND vacancy.date_closed >= ?2 AND vacancy.date_closed <= ?3"),
                @NamedNativeQuery(
                        name = "AVG_EXPERIENCE",
                        query = "SELECT AVG(?2 - employee.career_start_year)" +
                                "FROM country" +
                                "       INNER JOIN company ON country.id = company.country_id" +
                                "       INNER JOIN vacancy ON company.id = vacancy.company_id" +
                                "       INNER JOIN employee ON vacancy.employee_id = employee.id " +
                                "WHERE country.name = ?1  AND vacancy.date_closed > ?2 AND vacancy.date_opened < ?2"
                ), @NamedNativeQuery(
                name = "AVG_AGE",
                query = "SELECT AVG(?2 - employee.birth_year)" +
                        "FROM country" +
                        "       INNER JOIN company ON country.id = company.country_id" +
                        "       INNER JOIN vacancy ON company.id = vacancy.company_id" +
                        "       INNER JOIN employee ON vacancy.employee_id = employee.id " +
                        "WHERE country.name = ?1  AND vacancy.date_closed > ?2 AND vacancy.date_opened < ?2"
                ),
                @NamedNativeQuery(
                        name = "AVG_NUMBER_OF_EMPLOYEES",
                        query = "SELECT AVG (count_table.number_of_emp)" +
                                "FROM(" +
                                "    SELECT COUNT(vacancy.id) as number_of_emp, company.name" +
                                "    FROM company JOIN country ON company.country_id = country.id " +
                                "    JOIN vacancy ON vacancy.company_id = company.id" +
                                "    WHERE country.name = ?1 " +
                                "        AND  vacancy.date_closed > ?2" +
                                "        AND vacancy.date_opened < ?2" +
                                "    GROUP BY company.name) AS count_table"
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




