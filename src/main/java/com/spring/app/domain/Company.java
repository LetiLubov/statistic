package com.spring.app.domain;


import lombok.*;

import javax.persistence.*;
import java.util.Set;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(exclude = "id")
public class Company {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;

    @ManyToOne
//    @JoinColumn(name = "country_id")
    private Country country;

    @OneToMany
//    @JoinColumn(name = "vacancy_id")
    private Set<Vacancy> vacancy;

    public Company(String name) {
        this.name = name;
    }

}
