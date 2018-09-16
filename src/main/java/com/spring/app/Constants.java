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

    private Constants() throws IllegalAccessException {
        throw new IllegalAccessException();
    }
}