package com.deft.autowireddemo.conflict;

import org.springframework.stereotype.Component;

@Component("bar")
public class BarFormatter implements Formatter {

    @Override
    public String format() {
        return "Bar";
    }
}
