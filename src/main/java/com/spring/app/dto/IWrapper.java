package com.spring.app.dto;

import java.io.Serializable;

public interface IWrapper<F,T> extends Serializable {
    T fromEntity(F entity);
    F toEntity();
}
