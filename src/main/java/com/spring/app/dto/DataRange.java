package com.spring.app.dto;

import com.spring.app.Constants;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;

/**
 * A simple storage for a period of time
 * with default values for the beginning and end of the period
 *
 * @author Lyubov Ruzanova
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class DataRange implements Serializable {
    private Date validFrom = new Date(Integer.MIN_VALUE);
    private Date validTo = new Date();

    /**
     * Format the beginning of the period to String value by template
     */
    public String getValidFromToString(){
        return Constants.DATE_FORMAT.format(validFrom);
    }

    /**
     * Format the end of the period to String value by template
     */
    public String getValidToToString(){
        return Constants.DATE_FORMAT.format(validTo);
    }
}
