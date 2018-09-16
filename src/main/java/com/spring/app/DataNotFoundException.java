package com.spring.app;

/**
 * Exception throws when couldn't find any information in a DB
 *
 * @author Lyubov Ruzanova
 */
public class DataNotFoundException extends IllegalArgumentException {

    /**
     * Constructor to initialize an exception with additional info
     */
    public DataNotFoundException(String moreInfo) {
        super(MessageEnum.ERROR_DATA_NOT_FOUND.getErrorMessage(moreInfo));
    }
}
