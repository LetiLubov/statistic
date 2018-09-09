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
    private CompanyDAO repository;

    public CompanyService(@Autowired CompanyDAO repository) {
        this.repository = repository;
    }

    public List<CompanyDTO> getList(){
        return repository.findAll()
                        .stream()
                        .map(c -> new CompanyDTO().fromEntity(c))
                        .collect(Collectors.toList());
    }

    public void save(Company company){

        repository.create(company);
    }
}
