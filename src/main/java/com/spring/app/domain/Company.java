package com.spring.app.domain;


import lombok.*;

import javax.persistence.*;

/**
 * Company
 * Has a one-directional relation bound to country
 * @author Lyubov Ruzanova
 */

@Entity
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class Company extends BaseEntity {

    @Column(name = "COUNTRY_NAME")
    private String name;

    @ManyToOne
    @JoinColumn(name = "COUNTRY_ID")
    private Country country;
}
