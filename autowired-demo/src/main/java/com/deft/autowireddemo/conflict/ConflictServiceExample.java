package com.deft.autowireddemo.conflict;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class ConflictServiceExample {

    @Autowired
    @Qualifier("bar")
    private Formatter formatter;

    public String format() {
        return formatter.format();
    }
}
