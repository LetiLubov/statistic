package com.spring.app.dto;

import com.spring.app.EconomicLevel;
import lombok.AllArgsConstructor;
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
@AllArgsConstructor
public class CountryProfileDTO implements Serializable {
    private int numberOfVacancies;
    private int numberOfEmployees;
    private EconomicLevel economicLevel;
}
