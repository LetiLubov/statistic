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
public class EmployeeProfileDTOResultMapper implements GeneralResultMapper<List<Object[]>, Map<String, EmployeeProfileDTO>> {

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
                                    object -> StringResolveUtils.resolveStringValue(object[COUNTRY_INDEX]),
                                    object -> new EmployeeProfileDTO(
                                            new DoubleResultMapper().convertObject(object[SALARY_INDEX]),
                                            new IntegerResultMapper().convertObject(object[AGE_INDEX]),
                                            new IntegerResultMapper().convertObject(object[EXPERIENCE_INDEX]),
                                            new IntegerResultMapper().convertObject(object[NUM_OF_EMP_INDEX]))
                                    )
                            );
            return dtoHashMap;
        }
        throw new DataNotFoundException("Data not found.");
    }
}
