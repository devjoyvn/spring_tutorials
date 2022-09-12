package com.deft.autowireddemo.conflict;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ConflictByNameServiceExample {

    @Autowired
    private Formatter foo;

    public String format() {
        return foo.format();
    }
}
