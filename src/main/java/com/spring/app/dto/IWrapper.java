package com.spring.app.dto;

import java.io.Serializable;

/**
 * Wrapper's contract
 * Have two main methods convert from one object to another
 *
 * @author Lyubov Ruzanova
 */
public interface IWrapper<F,T> extends Serializable {
    T fromEntity(F entity);
    F toEntity();
}
