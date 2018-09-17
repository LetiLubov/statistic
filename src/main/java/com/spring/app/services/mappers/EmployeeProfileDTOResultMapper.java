package com.spring.app.services.mappers;

import com.spring.app.DataNotFoundException;
import com.spring.app.dto.EmployeeProfileDTO;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Map data set to pairs of employee profiles (as a value) and countries name (as a key)
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
            Map<String, EmployeeProfileDTO> dtoHashMap = new HashMap<>();
            for (Object[] object : objects) {
                if (object != null) {
                    String name = resolveStringValue(object[COUNTRY_INDEX]);
                    Double salary = DoubleResultMapper.getaDouble(object[SALARY_INDEX]);
                    Integer age = IntegerResultMapper.getInteger(object[AGE_INDEX]);
                    Integer experience = IntegerResultMapper.getInteger(object[EXPERIENCE_INDEX]);
                    Integer numOfEmp = IntegerResultMapper.getInteger(object[NUM_OF_EMP_INDEX]);

                    EmployeeProfileDTO employeeProfileDTO = new EmployeeProfileDTO();
                    employeeProfileDTO.setNumberOfEmployees(numOfEmp);
                    employeeProfileDTO.setExperience(experience);
                    employeeProfileDTO.setAge(age);
                    employeeProfileDTO.setSalary(salary);

                    dtoHashMap.put(name, employeeProfileDTO);
                } else {
                    throw new DataNotFoundException("The received value is incorrect.");
                }
            }
            return dtoHashMap;
        }
        throw new DataNotFoundException("Data not found.");
    }

    /**
     * Resolver for an object that should contain a String value
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
