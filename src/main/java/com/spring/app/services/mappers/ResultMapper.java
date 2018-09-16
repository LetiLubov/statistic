package com.spring.app.services.mappers;

import com.spring.app.DataNotFoundException;

/**
 * Convert input data to a new data
 *
 * @author Lyubov Ruzanova
 */
public interface ResultMapper<F, T> {
    /**
     * Map one value to another
     * @param f - input data
     * @return converted value
     */
    T map(F f) throws DataNotFoundException;
}
