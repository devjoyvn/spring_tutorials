package com.deft.autowireddemo.sample;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SetterExampleServiceImpl implements SetterExampleService {

    private SetterBean setterBean;

    @Autowired
    private void setBean(SetterBean setterBean) {
        this.setterBean = setterBean;
    }

    @Override
    public int getValue() {
        return setterBean.getValue();
    }
}
