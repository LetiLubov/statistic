package com.spring.app.dto;

import com.spring.app.Constants;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class DataRange implements Serializable {
    private Date validFrom = new Date(Integer.MIN_VALUE);
    private Date validTo = new Date(Integer.MAX_VALUE);

    public String getValidFromToString(){
        return Constants.DATE_FORMAT.format(validFrom);
    }
    public String getValidToToString(){
        return Constants.DATE_FORMAT.format(validTo);
    }
}
