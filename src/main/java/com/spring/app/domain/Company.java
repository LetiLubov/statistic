package com.spring.app.domain;


import lombok.*;

import javax.persistence.*;
import java.util.Set;

/**
 * Company
 * Has a one-directional relation bound to country
 * @author Lyubov Ruzanova
 */
@Entity
@NoArgsConstructor
@EqualsAndHashCode(exclude = "COMPANY_ID")
public class Company extends BaseEntity {

    @Column(name = "COUNTRY_NAME")
    private String name;

    @ManyToOne
    @JoinColumn(name = "COUNTRY_ID")
    private Country country;

    public Company(String name) {
        this.name = name;
    }
}
