package com.spring.app.domain.dao;

import com.spring.app.domain.Company;
import org.springframework.stereotype.Repository;

/**
 * DAO for Company
 * Has default features {@inheritDoc}
 *
 * @author Lyubov Ruzanova
 */
@Repository
public class CompanyDAO extends GenericDaoImpl<Company> {

    /**
     * Set Company.class as a persistent class
     */
    public CompanyDAO() {
        setPersistentClass(Company.class);
    }
}
