package com.spring.app.services.mappers;

import com.spring.app.DataNotFoundException;

/**
 * Converts input data to a new data
 *
 * @author Lyubov Ruzanova
 */
public interface ResultMapper<F, T> {
    /**
     * Maps one value to another
     * @param f - input data
     * @return converted value
     */
    T map(F f) throws DataNotFoundException;
}
