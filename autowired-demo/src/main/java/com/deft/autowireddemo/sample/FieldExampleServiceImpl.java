package com.deft.autowireddemo.sample;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FieldExampleServiceImpl implements FieldExampleService {


    @Autowired(required = false)
    private FieldBean fieldBean;

    @Override
    public String getName() {
        return fieldBean.getName();
    }
}
