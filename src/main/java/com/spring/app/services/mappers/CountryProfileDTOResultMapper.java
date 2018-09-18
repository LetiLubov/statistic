package com.spring.app.services.mappers;

import com.spring.app.DataNotFoundException;
import com.spring.app.EconomicLevel;
import com.spring.app.dto.CountryProfileDTO;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Map data set to pairs of country profiles (as a value) and countries name (as a key)
 *
 * @author Lyubov Ruzanova
 */
public class CountryProfileDTOResultMapper implements ResultMapper<List<Object[]>, Map<String, CountryProfileDTO>> {

    private static final int COUNTRY_INDEX = 0;
    private static final int ECONOMY_INDEX = 1;
    private static final int VAC_NUMBER_INDEX = 2;
    private static final int EMP_NUMBER_INDEX = 3;

    /**
     * {@InheritDoc}
     */
    @Override
    public Map<String, CountryProfileDTO> map(List<Object[]> objects) {
        if (objects != null && !objects.isEmpty()) {
            Map<String, CountryProfileDTO> dtoHashMap = new HashMap<>();
            for (Object[] object : objects) {
                if (object != null) {
                    String name = resolveStringValue(object[COUNTRY_INDEX]);
                    EconomicLevel economyIndex = EconomyLevelResultMapper.getEconomicLevel(object[ECONOMY_INDEX]);
                    Long vacNumber = LongResultMapper.getLong(object[VAC_NUMBER_INDEX]);
                    Long empNumber = LongResultMapper.getLong(object[EMP_NUMBER_INDEX]);

                    CountryProfileDTO countryProfileDTO = new CountryProfileDTO();
                    countryProfileDTO.setNumberOfEmployees(empNumber);
                    countryProfileDTO.setNumberOfVacancies(vacNumber);
                    countryProfileDTO.setEconomicLevel(economyIndex);

                    dtoHashMap.put(name, countryProfileDTO);
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
