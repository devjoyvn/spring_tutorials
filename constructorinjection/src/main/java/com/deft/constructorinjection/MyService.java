package com.deft.constructorinjection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MyService {

    private final Engine engine;
    private final Transmission transmission;
    @Autowired
    public MyService(Engine engine, Transmission transmission) {
        this.engine = engine;
        this.transmission = transmission;
    }
}
