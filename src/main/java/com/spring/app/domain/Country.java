package com.spring.app.domain;

import com.spring.app.EconomyLevel;
import lombok.*;

import javax.persistence.*;

/**
 * Country
 * Has an enum field that contains a living level
 *
 * @author Lyubov Ruzanova
 */

@NamedNativeQueries({
        @NamedNativeQuery(name = "MEAN_SALARY", query = "SELECT AVG(vacancy.salary) FROM country INNER JOIN company " +
                "ON country.country_id = company.country_id INNER JOIN vacancy ON company.company_id = vacancy.company_id " +
                "WHERE country.name = ?1 AND vacancy.opened = TRUE")
})
@Entity
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class Country extends BaseEntity {
    public static String MEAN_SALARY = "MEAN_SALARY";

    @Column(name = "COUNTRY_NAME")
    private String name;

    @Column(name = "LIVE_INDEX")
    @Enumerated(EnumType.STRING)
    private EconomyLevel economyLevel;
}




