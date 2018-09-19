package com.spring.app.dto;

import com.spring.app.EconomicLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

/**
 * Data transfer object for storage info about country's profile
 *
 * @author Lyubov Ruzanova
 */
@Getter
@Setter
@NoArgsConstructor
public class CountryProfileDTO implements Serializable {
    private long numberOfVacancies;
    private long numberOfEmployees;
    private EconomicLevel economicLevel;

    public CountryProfileDTO(long numberOfVacancies, long numberOfEmployees, EconomicLevel economicLevel) {
        this.numberOfVacancies = numberOfVacancies;
        this.numberOfEmployees = numberOfEmployees;
        this.economicLevel = economicLevel;
    }
}
