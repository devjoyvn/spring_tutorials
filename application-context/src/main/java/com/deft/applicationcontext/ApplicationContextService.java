package com.deft.applicationcontext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

@Service
public class ApplicationContextService {

    @Autowired
    private ApplicationContext applicationContext;


    public String getMyBeanName() {
        MyBean myBean = applicationContext.getBean(MyBean.class);

        return myBean.getName();
    }
}
