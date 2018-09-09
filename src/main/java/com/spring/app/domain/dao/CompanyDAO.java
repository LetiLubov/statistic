package com.spring.app.domain.dao;

import com.spring.app.domain.Company;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CompanyDAO extends GenericDaoImpl {
    public List<Company> getAllCompanies(){
        return em.createNativeQuery(Company.ALL_COMPANIES)
                    .getResultList();
    }
}
