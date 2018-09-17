package com.spring.app.domain;


import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

/**
 * Company
 * Has a one-directional relation bound to country
 * 
 * @author Lyubov Ruzanova
 */

@Entity
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class Company extends BaseEntity {

    @Column(name = "NAME")
    private String name;

    @ManyToOne
    @JoinColumn(name = "COUNTRY_ID")
    private Country country;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "DATE_OPENED")
    private Date dateOpened;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "DATE_CLOSED")
    private Date dateClosed;
}
