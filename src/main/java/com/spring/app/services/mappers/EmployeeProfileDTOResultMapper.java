package com.spring.app.services.mappers;

import com.spring.app.dto.EmployeeProfileDTO;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import java.util.Objects;
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
            return objects.stream()
                            .filter(Objects::nonNull)
                            .collect(Collectors.toMap(
                                    object -> (object[COUNTRY_INDEX] != null) ?
                                            object[COUNTRY_INDEX].toString() : "undefined",
                                    object -> new EmployeeProfileDTO(
                                            new WTFResultMapper<Double>().map(object[SALARY_INDEX]),
                                            new WTFResultMapper<Double>().map(object[AGE_INDEX]).intValue(),
                                            new WTFResultMapper<Double>().map(object[EXPERIENCE_INDEX]).intValue(),
                                            new WTFResultMapper<Double>().map(object[NUM_OF_EMP_INDEX]).intValue()
                                    )
                            ));
        }
        return null;
    }
}
