package com.spring.app.dto;

import com.spring.app.domain.Company;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

/**
 * Data transfer object for storage info about company
 *
 * @author Lyubov Ruzanova
 */
@Getter
@Setter
@NoArgsConstructor
public class CompanyDTO implements IWrapper<Company, CompanyDTO> {
    private String name;
    private CountryDTO country;
    private Date dateOpened = new Date(Integer.MIN_VALUE);
    private Date dateClosed;

    /**
     * Constructor for copying the Company object to the CompanyDTO object
     * @param company - storage for an entity from a DB
     */
    private CompanyDTO(Company company){
        this.name = company.getName();
        this.country = new CountryDTO().fromEntity(company.getCountry());
        this.dateOpened = company.getDateOpened();
        this.dateClosed = company.getDateClosed();
    }

    /**
     * {@inheritDoc}
     */    @Override
    public CompanyDTO fromEntity(Company entity) {
        return new CompanyDTO(entity);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Company toEntity() {
        Company company = new Company();
        company.setName(this.name);
        company.setCountry(this.country.toEntity());
        company.setDateOpened(this.dateOpened);
        company.setDateClosed(this.dateClosed);
        return company;
    }
}
