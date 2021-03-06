package com.spring.app.services.mappers;

import java.math.BigDecimal;
import java.math.BigInteger;

/**
 * Maps input data to a new data of correct type
 *
 * @author Lyubov Ruzanova
 */
public interface ResultMapper<R, T> {
    /**
     * Maps one value to another of correct type
     *
     * @param r - input data
     * @return converted value
     */
    T map(R r);

    /**
     * Maps object to Integer
     *
     * @param object - input value
     * @return object casted to Integer
     */
    static Integer getInteger(Object object) {
        return getDouble(object).intValue();
    }

    /**
     * Maps object to Double
     *
     * @param object - input value
     * @return object casted to Double
     */
    static Double getDouble(Object object) {
        if (object != null && object instanceof Number) {
            return ((Number) object).doubleValue();
        }
        return 0d;
    }
}
