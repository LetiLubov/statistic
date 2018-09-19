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
public class IntegerResultMapper implements ResultMapper<Object, Integer> {
    private static final int INDEX = 0;

    /**
     * {@InheritDoc}
     */
    @Override
    public Integer map(List<Object> objects) throws DataNotFoundException {
        if (objects != null && !objects.isEmpty() && objects.get(INDEX) != null) {
            return convertObject(objects.get(INDEX));
        }
        return 0;
    }

    /**
     * Resolver for an value of the Object type that must contains a int value
     *
     * @param object - input
     * @return converted object
     */
    @Override
    public Integer convertObject(Object object) throws DataNotFoundException {
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
