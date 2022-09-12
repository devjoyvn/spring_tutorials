package com.deft.componentscan;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MyService {

    @Autowired
    private MyBean myBean;

    public void getMyBeanName() {
        System.out.println(myBean.getName());
    }
}
