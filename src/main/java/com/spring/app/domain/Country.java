package com.spring.app.domain;

import com.spring.app.CountryLevel;
import lombok.*;

import javax.persistence.*;
import java.util.Set;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(exclude = "id")
public class Country {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private CountryLevel countryLevel;

    @OneToMany
    private Set<Company> companies;

    public Country(String name, CountryLevel countryLevel) {
        this.name = name;
        this.countryLevel = countryLevel;
    }
    public Country(String name) {
        this.name = name;
    }
}
