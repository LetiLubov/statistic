package com.spring.app.domain;


import lombok.*;

import javax.persistence.*;

/**
 * Company
 * Has a one-directional relation bound to country
 * @author Lyubov Ruzanova
 */

@NamedNativeQueries({
        @NamedNativeQuery(name = "ALL_COMPANIES", query = "SELECT * FROM country")
})
@Entity
@NoArgsConstructor
@EqualsAndHashCode(exclude = "COMPANY_ID")
public class Company extends BaseEntity {
    public static String ALL_COMPANIES = "ALL_COMPANIES";

    @Getter
    @Setter
    @Column(name = "COUNTRY_NAME")
    private String name;

    @ManyToOne
    @JoinColumn(name = "COUNTRY_ID")
    private Country country;

    public Company(String name) {
        this.name = name;
    }

    public Company(Company company){
        this.id = company.id;
        this.country = company.getCountry();
        this.name = company.getName();
    }

    public Country getCountry() {
        return new Country(country);
    }

    public void setCountry(Country country) {
        this.country = new Country(country);
    }


}
