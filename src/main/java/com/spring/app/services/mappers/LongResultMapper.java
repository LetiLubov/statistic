package com.spring.app.services.mappers;

import com.spring.app.DataNotFoundException;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.List;

/**
 * Maps data set to single value and cast it to Long
 *
 * @author Lyubov Ruzanova
 */
public class LongResultMapper implements ResultMapper<List<Object>, Long> {
    private static final int INDEX = 0;

    /**
     * {@InheritDoc}
     */
    @Override
    public Long map(List<Object> objects) throws DataNotFoundException {
        if (objects != null && !objects.isEmpty() && objects.get(INDEX) != null) {
            Object object = objects.get(INDEX);
            return getLong(object);
        }
        throw new DataNotFoundException("Data not found.");
    }

    /**
     * Resolver for an object that should contains an Long value
     *
     * @param object - input
     * @return converted object
     */
    public static Long getLong(Object object) {
        if (object == null){
            throw new DataNotFoundException("Data not found.");
        }
        if (object instanceof BigDecimal) {
            return ((BigDecimal) object).longValue();
        }else if (object instanceof BigInteger) {
            return ((BigInteger) object).longValue();
        }else if (object instanceof Double) {
            return ((Double) object).longValue();
        }
        throw new DataNotFoundException("The received value is incorrect.");
    }
}
