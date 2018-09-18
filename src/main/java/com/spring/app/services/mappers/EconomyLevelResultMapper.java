package com.spring.app.services.mappers;

import com.spring.app.DataNotFoundException;
import com.spring.app.EconomicLevel;

import java.util.List;

/**
 * Maps data set to single value and cast it to EconomicLevel
 *
 * @author Lyubov Ruzanova
 */
public class EconomyLevelResultMapper implements ResultMapper<List<Object>, EconomicLevel> {

    private static final int SALARY_INDEX = 0;

    /**
     * {@InheritDoc}
     */
    @Override
    public EconomicLevel map(List<Object> objects) throws DataNotFoundException {
        if (objects != null && !objects.isEmpty()) {
            Object object = objects.get(SALARY_INDEX);
            return getEconomicLevel(object);
        }
        throw new DataNotFoundException("Data not found.");
    }

    /**
     * Resolver for an object that should contains the economic level value
     *
     * @param object - input
     * @return converted object
     */
    public static EconomicLevel getEconomicLevel(Object object) {
        if (object == null){
            throw new DataNotFoundException("Data not found.");
        }
        if (object instanceof EconomicLevel) {
            return (EconomicLevel) object;
        } else if (object instanceof String) {
            try {
               return EconomicLevel.valueOf((String) object);
            } catch (IllegalArgumentException ex) {
                throw new DataNotFoundException("The country level is undefined.");
            }
        }
        throw new DataNotFoundException("The received value is incorrect.");
    }
}