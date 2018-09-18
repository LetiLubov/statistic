package com.spring.app.services;

import com.spring.app.domain.Company;
import com.spring.app.domain.dao.CompanyDAO;
import com.spring.app.dto.CompanyDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Service for company
 *
 * @author Lyubov Ruzanova
 */
@Service
public class CompanyService {
    private final CompanyDAO repository;

    /**
     * Injects a company repository
     * @param repository - company repository
     */
    public CompanyService(@Autowired CompanyDAO repository) {
        this.repository = repository;
    }

    /**
     * Gets all companies from repository and converts them to CompanyDTO format
     * @return list of companies
     */
    public List<CompanyDTO> getList(){
        return repository.findAll()
                .stream()
                .map(c -> new CompanyDTO().fromEntity(c))
                .collect(Collectors.toList());
    }

    /**
     * Saves a new company to DB
     * @param company - the company to save in DB
     */
    public void save(Company company){
        repository.create(company);
    }
}
