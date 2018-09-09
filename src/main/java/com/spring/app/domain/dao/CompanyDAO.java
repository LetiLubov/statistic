package com.spring.app.domain.dao;

import com.spring.app.domain.Company;
import org.springframework.stereotype.Repository;

@Repository
public class CompanyDAO extends GenericDaoImpl<Company> {
    public CompanyDAO() {
        setPersistentClass(Company.class);
    }
}
