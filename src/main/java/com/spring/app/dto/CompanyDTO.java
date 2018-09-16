package com.spring.app.dto;

import com.spring.app.domain.Company;
import com.spring.app.domain.Country;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
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
    private Date dateOpened;
    private Date dateClosed;

    private CompanyDTO(Company company){
        this.name = company.getName();
        this.country = new CountryDTO().fromEntity(company.getCountry());
        this.dateOpened = company.getDateOpened();
        this.dateClosed = company.getDateClosed();
    }

    @Override
    public CompanyDTO fromEntity(Company entity) {
        return new CompanyDTO(entity);
    }

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
