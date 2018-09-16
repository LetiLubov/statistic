package com.spring.app;

/**
 * Constants
 *
 * @author Lyubov Ruzanova
 */
public final class Constants {
    public final static String MEAN_SALARY_TEXT_MESSAGE = "Mean salary between %d-%d in %s is %f";
    public final static String AVG_EXPERIENCE_TEXT_MESSAGE = "Average experience of employees in %s is %d";
    public final static String AVG_AGE_TEXT_MESSAGE = "Average age of employees in %s is %d";
    public final static String AVG_NUM_OF_EMP_TEXT_MESSAGE = "Average number of employees in companies in %s is %d";

    public final static String NO_SALARY_INFO_FOUND_ERROR_TEXT_MESSAGE = "There is no information about the salary for this period";
    public final static String NO_EMP_FOUND_ERROR_TEXT_MESSAGE = "There is no information about employees for this period";

    private Constants() throws IllegalAccessException {
        throw new IllegalAccessException();
    }
}