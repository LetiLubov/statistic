package com.spring.app.dto;

import com.spring.app.domain.Company;
import com.spring.app.domain.Country;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * CompanyDTO
 * Data layer for storage info about company
 * @author Lyubov Ruzanova
 */
@Getter
@Setter
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
        return new CompanyDTO(entity);
    }

    @Override
    public Company toEntity() {
        Company company = new Company();
        company.setName(this.name);
        company.setCountry(this.country);
        return company;
    }
}
