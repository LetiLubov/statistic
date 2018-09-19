package com.spring.app.services.mappers;

import com.spring.app.DataNotFoundException;

import java.util.List;

/**
 * Converts input data to a new data
 *
 * @author Lyubov Ruzanova
 */
public interface ResultMapper<F, R extends List<F>, T> extends GeneralResultMapper<R, T> {

    /**
     * Convert one value to another
     * @param t - input data
     * @return converted value
     */
    T convertObject(F t) throws DataNotFoundException;
}
