package com.spring.app.services;

import com.spring.app.domain.Company;
import com.spring.app.domain.dao.CompanyDAO;
import com.spring.app.dto.CompanyDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CompanyService {
    @Autowired
    private CompanyDAO repository;

    public List<CompanyDTO> getAllCompanies(){
        return repository.findAll()
                        .stream()
                        .map(c -> new CompanyDTO().fromEntity(c))
                        .collect(Collectors.toList());
    }

    public void saveCompany(Company company){
        repository.create(company);
    }
}
