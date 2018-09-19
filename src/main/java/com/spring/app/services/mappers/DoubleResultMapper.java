package com.spring.app.services.mappers;

import com.spring.app.DataNotFoundException;

import java.math.BigDecimal;
import java.util.List;

/**
 * Maps data set to single value and cast it to Double
 *
 * @author Lyubov Ruzanova
 */
public class DoubleResultMapper implements ResultMapper<Object, Double> {

    private static final int SALARY_INDEX = 0;

    /**
     * {@InheritDoc}
     */
    @Override
    public Double map(List<Object> objects) throws DataNotFoundException {
        if (objects != null && !objects.isEmpty()) {
            return convertObject(objects.get(SALARY_INDEX));
        }
        return 0d;
    }

    /**
     * Resolver for an value of the Object type that must contains a double value
     *
     * @param object - input
     * @return converted object
     */
    @Override
    public Double convertObject(Object object) throws DataNotFoundException {
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
