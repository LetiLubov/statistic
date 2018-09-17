package com.spring.app.dto;

import java.io.Serializable;

/**
 * Wrapper's contract
 * Have two main methods convert from one object to another
 *
 * @author Lyubov Ruzanova
 */
public interface IWrapper<F,T> extends Serializable {
    /**
     * Wrapped the original object to a new one, saving all its main properties
     * @param entity - input original entity
     * @return Wrapped entity
     */
    T fromEntity(F entity);
    /**
     * Convert a wrapped object back to an entity, saving all its main properties
     * @return original object
     */
    F toEntity();
}
