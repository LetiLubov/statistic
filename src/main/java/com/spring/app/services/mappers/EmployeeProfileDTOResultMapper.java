package com.spring.app.services.mappers;

import com.spring.app.DataNotFoundException;
import com.spring.app.dto.EmployeeProfileDTO;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Maps data set to pairs of employee profiles (as a value) and countries name (as a key)
 *
 * @author Lyubov Ruzanova
 */
public class EmployeeProfileDTOResultMapper implements ResultMapper<List<Object[]>, Map<String, EmployeeProfileDTO>> {

    private static final int COUNTRY_INDEX = 0;
    private static final int SALARY_INDEX = 1;
    private static final int AGE_INDEX = 2;
    private static final int EXPERIENCE_INDEX = 3;
    private static final int NUM_OF_EMP_INDEX = 4;

    /**
     * {@InheritDoc}
     */
    @Override
    public Map<String, EmployeeProfileDTO> map(List<Object[]> objects) {
        if (objects != null && !objects.isEmpty()) {
            Map<String, EmployeeProfileDTO> dtoHashMap =
                    objects.stream()
                            .filter(x -> x!= null)
                            .collect(Collectors.toMap(
                                    object -> resolveStringValue(object[COUNTRY_INDEX]),
                                    object -> new EmployeeProfileDTO(
                                            DoubleResultMapper.getDouble(object[SALARY_INDEX]),
                                            IntegerResultMapper.getInteger(object[AGE_INDEX]),
                                            IntegerResultMapper.getInteger(object[EXPERIENCE_INDEX]),
                                            IntegerResultMapper.getInteger(object[NUM_OF_EMP_INDEX]))
                                    )
                            );

            return dtoHashMap;
        }
        throw new DataNotFoundException("Data not found.");
    }

    /**
     * Resolver for an object that should contains a String value
     *
     * @param object - input
     * @return converted object
     */
    private String resolveStringValue(Object object) {
        if (object != null) {
            if (object instanceof String) {
                return object.toString();
            }
            throw new DataNotFoundException("The received value is incorrect.");
        }
        throw new DataNotFoundException("Data not found.");
    }
}
