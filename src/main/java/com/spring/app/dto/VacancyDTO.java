package com.spring.app.dto;

import com.spring.app.domain.Vacancy;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

/**
 * Data transfer object for storage info about vacancy
 *
 * @author Lyubov Ruzanova
 */
@Getter
@Setter
@NoArgsConstructor
public class VacancyDTO implements IWrapper<Vacancy, VacancyDTO> {

    private String name;
    private double salary;
    private boolean isOpened;
    private EmployeeDTO employee;
    private CompanyDTO company;
    private Date dateOpened = new Date(Integer.MIN_VALUE);
    private Date dateClosed;

    /**
     * Constructor for copying the Vacancy object to the VacancyDTO object
     * @param vacancy - storage for an entity from a DB
     */
    private VacancyDTO(Vacancy vacancy){
        this.name = vacancy.getName();
        this.salary = vacancy.getSalary();
        this.isOpened = vacancy.isOpened();
        this.employee = new EmployeeDTO().fromEntity(vacancy.getEmployee());
        this.company = new CompanyDTO().fromEntity(vacancy.getCompany());
        this.dateOpened = vacancy.getDateOpened();
        this.dateClosed = vacancy.getDateClosed();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public VacancyDTO fromEntity(Vacancy entity) {
        return new VacancyDTO(entity);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Vacancy toEntity() {
        Vacancy vacancy = new Vacancy();
        vacancy.setName(this.name);
        vacancy.setSalary(this.salary);
        vacancy.setOpened(this.isOpened);
        vacancy.setEmployee(this.employee.toEntity());
        vacancy.setCompany(this.company.toEntity());
        vacancy.setDateOpened(this.dateOpened);
        vacancy.setDateClosed(this.dateClosed);
        return vacancy;
    }
}
