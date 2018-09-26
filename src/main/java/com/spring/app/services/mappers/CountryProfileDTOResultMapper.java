package com.spring.app.services.mappers;

import com.spring.app.EconomicLevel;
import com.spring.app.dto.CountryProfileDTO;

import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * Maps data set to pairs of country profiles (as a value) and countries name (as a key)
 *
 * @author Lyubov Ruzanova
 */
public class CountryProfileDTOResultMapper implements ResultMapper<List<Object[]>, Map<String, CountryProfileDTO>> {

    private static final int COUNTRY_INDEX = 0;
    private static final int VAC_NUMBER_INDEX = 1;
    private static final int EMP_NUMBER_INDEX = 2;
    private static final int ECONOMY_INDEX = 3;

    /**
     * {@InheritDoc}
     */
    @Override
    public Map<String, CountryProfileDTO> map(List<Object[]> objects) {
        if (objects != null && !objects.isEmpty()) {
            Map<String, CountryProfileDTO> collect = objects.stream()
                    .filter(Objects::nonNull)
                    .filter(object -> object[COUNTRY_INDEX] != null)
                    .collect(Collectors.toMap(
                            object -> object[COUNTRY_INDEX].toString(),
                            object -> new CountryProfileDTO(
                                    ResultMapper.getInteger(object[VAC_NUMBER_INDEX]),
                                    ResultMapper.getInteger(object[EMP_NUMBER_INDEX]),
                                    resolveEconomicLevelValue(object[ECONOMY_INDEX])
                            ))
                    );
            return collect;

        }
        return null;
    }

    /**
     * Resolver for an value of the Object type that must contains a economic level value
     *
     * @param object - input
     * @return converted object
     */
    public EconomicLevel resolveEconomicLevelValue(Object object) {
        try {
            return EconomicLevel.valueOf((String) object);
        } catch (IllegalArgumentException ex) {
            return EconomicLevel.UNDEFINED;
        }
    }
}
