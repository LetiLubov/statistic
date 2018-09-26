package com.spring.app.dto;

import com.spring.app.EconomicLevel;
import com.spring.app.domain.Country;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Data transfer object for storage info about country
 *
 * @author Lyubov Ruzanova
 */
@Getter
@Setter
@NoArgsConstructor
public class CountryDTO implements IWrapper<Country, CountryDTO> {
    private String name;
    private EconomicLevel economicLevel;

    /**
     * Constructor for copying the Country object to the CountryDTO object
     * @param country - storage for an entity from a DB
     */
    private CountryDTO(Country country){
        this.name = country.getName();
        this.economicLevel = country.getEconomicLevel();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public CountryDTO fromEntity(Country entity) {
        return new CountryDTO(entity);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Country toEntity() {
        Country country = new Country();
        country.setName(this.name);
        country.setEconomicLevel(this.economicLevel);
        return country;
    }
}
