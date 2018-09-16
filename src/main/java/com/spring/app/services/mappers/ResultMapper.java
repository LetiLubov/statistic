package com.spring.app.services.mappers;

public interface ResultMapper<F, T> {
    T map(F f);
    
}
