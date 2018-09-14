package com.spring.app.domain.dao;

import com.spring.app.domain.Company;
import org.springframework.stereotype.Repository;

/**
 * DAO for Company
 * Has default features
 * @see GenericDAO
 *
 * @author Lyubov Ruzanova
 */
@Repository
public class CompanyDAO extends GenericDaoImpl<Company> {
    public CompanyDAO() {
        setPersistentClass(Company.class);
    }
}
