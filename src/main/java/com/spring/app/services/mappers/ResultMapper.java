package com.spring.app.services.mappers;

/**
 * Maps input data to a new data of correct type
 *
 * @author Lyubov Ruzanova
 */
public interface ResultMapper<R, T> {
    /**
     * Maps one value to another of correct type
     * @param r - input data
     * @return converted value
     */
    T map(R r);
}
