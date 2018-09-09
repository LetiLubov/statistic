package com.spring.app.dto;

import com.spring.app.domain.Company;
import com.spring.app.domain.Country;
import lombok.NoArgsConstructor;

/**
 * CompanyDTO
 * Data layer for storage info about company
 * @author Lyubov Ruzanova
 */
@NoArgsConstructor
public class CompanyDTO implements IWrapper<Company, CompanyDTO> {
    private String name;
    private Country country;

    private CompanyDTO(Company company){
        this.name = company.getName();
        this.country = company.getCountry();
    }

    @Override
    public CompanyDTO fromEntity(Company entity) {
        return null;
    }

    @Override
    public Company toEntity() {
        return null;
    }
}
