package com.spring.app.services.mappers;

import java.math.BigDecimal;
import java.util.List;

public class IntegerResultMapper implements ResultMapper<List<Object>, Integer> {
    private static final int INDEX = 0;

    @Override
    public Integer map(List<Object> objects) {
        if (objects != null && !objects.isEmpty() && objects.get(INDEX) != null) {
            Object object = objects.get(INDEX);
            if (object instanceof BigDecimal) {
                return ((BigDecimal) object).intValue();
            }
            if (object instanceof Double) {
                return ((Double) object).intValue();
            }
        }
        return 0;
    }
}
