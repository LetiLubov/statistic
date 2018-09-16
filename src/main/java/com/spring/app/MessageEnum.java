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

    //Error messages for result response
    ERROR_NO_SALARY_INFO_FOUND("There is no information about the salary for this period"),
    ERROR_NO_EMP_FOUND("There is no information about employees for this period"),

    //For exception handler
    ERROR_AT_RUNTIME("Oops! Something went wrong, please contact Lyubov \n Telegram: @akelanova"),
    ERROR_INVALID_DATA_ACCESS("Oops! Failed to get response from database, please contact Lyubov \n Telegram: @akelanov");

    private String message;

    public String getErrorMessage(Object... objects) {
        return String.format(message, objects);
    }

}
