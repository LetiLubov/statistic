package com.spring.app;

import lombok.AllArgsConstructor;

import java.io.Serializable;

/**
 * Message templates
 *
 * @author Lyubov Ruzanova
 */
@AllArgsConstructor
public enum MessageEnum implements Serializable {
    //Messages for result response
    MEAN_SALARY("Mean salary between %s-%s in %s is %f"),
    AVG_EXPERIENCE("Average experience of employees in %s is %d"),
    AVG_AGE("Average age of employees in %s is %d"),
    AVG_NUM_OF_EMP("Average number of employees in companies in %s is %d"),

    //For exception handler
    ERROR_AT_RUNTIME("Oops! Something went wrong, please contact Lyubov \n Telegram: @akelanova"),
    ERROR_INVALID_DATA_ACCESS("Oops! Failed to get response from database, please contact Lyubov \n Telegram: @akelanov"),
    ERROR_DATA_NOT_FOUND("Sorry! Couldn't process the request correctly :(\n%s");

    private String message;

    /**
     * Completes the message template with the args value information
     * @param objects - arguments
     */
    public String getMessage(Object... objects) {
        return String.format(message, objects);
    }

}
