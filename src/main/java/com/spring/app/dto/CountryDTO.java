package com.spring.app.dto;

import com.spring.app.QualityOfLiveIndex;
import com.spring.app.domain.Country;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * CountryDTO
 * Data layer for storage info about country
 * @author Lyubov Ruzanova
 */
@Getter
@Setter
@NoArgsConstructor
public class CountryDTO implements IWrapper<Country, CountryDTO> {
    private String name;
    private QualityOfLiveIndex qualityOfLiveIndex;

    private CountryDTO(Country country){
        this.name = country.getName();
        this.qualityOfLiveIndex = country.getQualityOfLiveIndex();
    }

    @Override
    public CountryDTO fromEntity(Country entity) {
        return new CountryDTO(entity);
    }

    @Override
    public Country toEntity() {
        Country country = new Country();
        country.setName(this.name);
        country.setQualityOfLiveIndex(this.qualityOfLiveIndex);
        return country;
    }
}
