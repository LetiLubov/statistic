package com.spring.app.services.mappers;

import com.spring.app.DataNotFoundException;

import java.math.BigDecimal;
import java.util.List;

/**
 * Map data set to single value and cast it to Double
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
        if (objects != null && !objects.isEmpty() && objects.get(SALARY_INDEX) != null) {
            Object object = objects.get(SALARY_INDEX);
            if (object instanceof BigDecimal){
                return ((BigDecimal) object).doubleValue();
            }
            else if (object instanceof Double){
                return (Double) object;
            }
            throw new DataNotFoundException("The received value is incorrect.");
        }
        throw new DataNotFoundException("Data not found.");
    }
}
