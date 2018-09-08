package com.spring.app.domain;

import com.spring.app.QualityOfLiveIndex;
import lombok.*;

import javax.persistence.*;

/**
 * Country
 * Has an enum field that contains a living level
 * @author Lyubov Ruzanova
 */
@Entity
@NoArgsConstructor
@EqualsAndHashCode(exclude = "COUNTRY_ID")
public class Country extends BaseEntity {

    @Column(name = "COUNTRY_NAME")
    private String name;

    @Column(name = "LIVE_INDEX")
    @Enumerated(EnumType.STRING)
    private QualityOfLiveIndex qualityOfLiveIndex;

    public Country(String name) {
        this.name = name;
    }
}
