package com.spring.app.services.mappers;

import com.spring.app.DataNotFoundException;

import java.math.BigDecimal;
import java.util.List;

/**
 * Map data set to single value and cast it to Integer
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
            Object object = objects.get(INDEX);
            if (object instanceof BigDecimal) {
                return ((BigDecimal) object).intValue();
            }
            if (object instanceof Double) {
                return ((Double) object).intValue();
            }
            throw new DataNotFoundException("The received value is incorrect.");
        }
        throw new DataNotFoundException("Data not found.");
    }
}
