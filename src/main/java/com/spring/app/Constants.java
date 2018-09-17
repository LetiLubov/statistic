package com.spring.app;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Locale;

/**
 * Constants
 *
 * @author Lyubov Ruzanova
 */
public final class Constants {
    public final static DateFormat DATE_FORMAT = new SimpleDateFormat("yyyy-mm-dd", Locale.ENGLISH);

    /**
     * Doesn't need to provide a possibility to create instance of this class
     * @throws IllegalAccessException - any way
     */
    private Constants() throws IllegalAccessException {
        throw new IllegalAccessException();
    }
}