package com.spring.app.services.mappers;

import com.spring.app.DataNotFoundException;

/**
 * Maps input data to a new data of correct type
 *
 * @author Lyubov Ruzanova
 */
public interface GeneralResultMapper<R, T> {
    /**
     * Maps one value to another of correct type
     * @param r - input data
     * @return converted value
     */
    T map(R r) throws DataNotFoundException;
}
