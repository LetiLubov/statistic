package com.spring.app.services.mappers;

import java.math.BigDecimal;
import java.math.BigInteger;

public class WTFResultMapper<T extends Number> implements ResultMapper<Object, T> {

    @Override
    public T map(Object object) {
        if (object != null) {
            if (object instanceof BigDecimal) {
                Double res = ((BigDecimal) object).doubleValue();
                return (T) res;
            } else if (object instanceof BigInteger) {
                Integer res = ((BigInteger) object).intValue();
                return (T) res;
            } else if (object instanceof Double) {
                return (T) object;
            }
        }
        return null;
    }
}
