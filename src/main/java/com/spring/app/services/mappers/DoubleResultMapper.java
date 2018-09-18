package com.spring.app.services.mappers;

import com.spring.app.DataNotFoundException;

import java.math.BigDecimal;
import java.util.List;

/**
 * Maps data set to single value and cast it to Double
 *
 * @author Lyubov Ruzanova
 */
public class DoubleResultMapper implements ResultMapper<List<Object>, Double> {

    private static final int SALARY_INDEX = 0;

    /**
     * {@InheritDoc}
     */
    @Override
    public Double map(List<Object> objects) throws DataNotFoundException {
        if (objects != null && !objects.isEmpty()) {
            return getDouble(objects.get(SALARY_INDEX));
        }
        throw new DataNotFoundException("Data not found.");
    }

    /**
     * Resolver for an object that should contains a double value
     *
     * @param object - input
     * @return converted object
     */
    public static Double getDouble(Object object) {
        if (object == null) {
            throw new DataNotFoundException("Data not found.");
        }
        if (object instanceof BigDecimal) {
            return ((BigDecimal) object).doubleValue();
        } else if (object instanceof Double) {
            return (Double) object;
        }
        throw new DataNotFoundException("The received value is incorrect.");
    }
}
