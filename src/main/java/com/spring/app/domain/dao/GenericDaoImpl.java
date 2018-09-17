package com.spring.app.domain.dao;

import com.spring.app.domain.BaseEntity;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

/**
 * Simple generic implementation of {@link GenericDAO} with a provided
 * base methods implementation from the parent class {@link AbstractDAO}
 * Scope is set to {@link BeanDefinition#SCOPE_PROTOTYPE} in order to
 * provide a new instance of DAO into any bean to eliminate a problem
 * of running DAOs with a different parameters
 *
 * @param <T> - type of entity
 * @author Evgenii Ray
 */
@Repository
@Scope(BeanDefinition.SCOPE_PROTOTYPE)
public class GenericDaoImpl<T extends BaseEntity> extends AbstractDAO<T> implements GenericDAO<T> {}