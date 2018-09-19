package com.spring.app.services.mappers;

import com.spring.app.DataNotFoundException;
import com.spring.app.EconomicLevel;
import com.spring.app.dto.CountryProfileDTO;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Maps data set to pairs of country profiles (as a value) and countries name (as a key)
 *
 * @author Lyubov Ruzanova
 */
public class CountryProfileDTOResultMapper implements GeneralResultMapper<List<Object[]>, Map<String, CountryProfileDTO>> {

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
            Map<String, CountryProfileDTO> dtoHashMap =
                    objects.stream()
                            .filter(x -> x != null)
                            .collect(Collectors.toMap(
                                    object -> StringResolveUtils.resolveStringValue(object[COUNTRY_INDEX]),
                                    object -> new CountryProfileDTO(
                                            new LongResultMapper().convertObject(object[VAC_NUMBER_INDEX]),
                                            new LongResultMapper().convertObject(object[EMP_NUMBER_INDEX]),
                                            resolveEconomicLevelValue(object[ECONOMY_INDEX])))
                            );
            return dtoHashMap;
        }
        return new HashMap<>();
    }

    /**
     * Resolver for an value of the Object type that must contains a economic level value
     *
     * @param object - input
     * @return converted object
     */
    public EconomicLevel resolveEconomicLevelValue(Object object) throws DataNotFoundException {
        if (object == null){
            throw new DataNotFoundException("Data not found.");
        }
        if (object instanceof String) {
            try {
                return EconomicLevel.valueOf((String) object);
            } catch (IllegalArgumentException ex) {
                throw new DataNotFoundException("The country level is undefined.");
            }
        }
        throw new DataNotFoundException("The received value is incorrect.");
    }
}
