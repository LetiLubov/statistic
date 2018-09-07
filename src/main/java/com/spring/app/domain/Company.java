package com.spring.app.domain;


import lombok.*;

import javax.persistence.*;
import java.util.Set;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(exclude = "company_id")
public class Company {
    @Id
    @Column(name = "company_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;

    @ManyToOne
    @JoinColumn(name = "country_id")
    private Country country;

//    @OneToMany(mappedBy = "company", fetch = FetchType.LAZY, cascade=CascadeType.ALL)
//    private Set<Vacancy> vacancy;

    public Company(String name) {
        this.name = name;
    }

}
