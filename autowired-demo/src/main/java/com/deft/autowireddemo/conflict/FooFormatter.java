package com.deft.autowireddemo.conflict;

import org.springframework.stereotype.Component;

@Component("foo")
public class FooFormatter implements Formatter {
    @Override
    public String format() {
        return "Foo";
    }
}
