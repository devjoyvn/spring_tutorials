package com.deft.autowireddemo;

import com.deft.autowireddemo.conflict.ConflictByNameServiceExample;
import com.deft.autowireddemo.conflict.ConflictServiceExample;
import com.deft.autowireddemo.sample.ConstructorExampleService;
import com.deft.autowireddemo.sample.FieldExampleService;
import com.deft.autowireddemo.sample.SetterExampleService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class AutowiredDemoApplicationTests {

    @Autowired
    private FieldExampleService fieldExampleService;

    @Autowired
    private SetterExampleService setterExampleService;

    @Autowired
    private ConstructorExampleService constructorExampleService;

    @Autowired
    private ConflictServiceExample conflictServiceExample;

    @Autowired
    private ConflictByNameServiceExample conflictByNameServiceExample;

    @Test
    public void propertyAutowiredTest() {
        assertEquals(fieldExampleService.getName(), "Deft Blog");
    }

    @Test
    public void setterAutowiredTest() {
        assertEquals(setterExampleService.getValue(), 10);
    }

    @Test
    public void constructorAutowiredTest() {
        assertEquals(constructorExampleService.print(), "Deft Blog - 10");
    }

    @Test
    public void conflictAutowiredTest() {
        assertEquals(conflictServiceExample.format(),  "Bar");
    }

    @Test
    public void conflictByNameServiceExampleTest() {
        assertEquals(conflictByNameServiceExample.format(),  "Foo");

    }

}
