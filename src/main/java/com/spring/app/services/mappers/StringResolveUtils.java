package com.spring.app.services.mappers;

import com.spring.app.DataNotFoundException;

public final class StringResolveUtils {
    /**
     * Resolver for an object that should contains a String value
     *
     * @param object - input
     * @return converted object
     */
    public static String resolveStringValue(Object object) {
            if (object instanceof String) {
                return object.toString();
            }
            throw new DataNotFoundException("The received value is incorrect.");
    }
}
