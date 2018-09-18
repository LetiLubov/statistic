package com.spring.app.services.mappers;

import com.spring.app.DataNotFoundException;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.List;

/**
 * Maps data set to single value and cast it to Integer
 *
 * @author Lyubov Ruzanova
 */
public class IntegerResultMapper implements ResultMapper<List<Object>, Integer> {
    private static final int INDEX = 0;

    /**
     * {@InheritDoc}
     */
    @Override
    public Integer map(List<Object> objects) throws DataNotFoundException {
        if (objects != null && !objects.isEmpty() && objects.get(INDEX) != null) {
            return getInteger(objects.get(INDEX));
        }
        throw new DataNotFoundException("Data not found.");
    }

    /**
     * Resolver for an object that should contains an integer value
     *
     * @param object - input
     * @return converted object
     */
    public static Integer getInteger(Object object) {
        if (object == null) {
            throw new DataNotFoundException("Data not found.");
        }
        if (object instanceof BigDecimal) {
            return ((BigDecimal) object).intValue();
        } else if (object instanceof BigInteger) {
            return ((BigInteger) object).intValue();
        } else if (object instanceof Double) {
            return ((Double) object).intValue();
        }
        throw new DataNotFoundException("The received value is incorrect.");
    }
}
