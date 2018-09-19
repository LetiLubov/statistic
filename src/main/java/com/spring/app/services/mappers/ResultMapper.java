package com.spring.app.services.mappers;

import com.spring.app.DataNotFoundException;

import java.util.List;

/**
 * Converts input data to a new data
 *
 * @author Lyubov Ruzanova
 */
public interface ResultMapper<F, T> extends GeneralResultMapper<List<F>, T> {

    /**
     * Convert one value to another
     * @param f - input data
     * @return converted value
     */
    T convertObject(F f) throws DataNotFoundException;
}
