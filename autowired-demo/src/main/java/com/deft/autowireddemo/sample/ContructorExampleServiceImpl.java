package com.deft.autowireddemo.sample;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.yaml.snakeyaml.constructor.ConstructorException;

@Service
public class ContructorExampleServiceImpl implements ConstructorExampleService {

    private final FieldBean fieldBean;

    private final SetterBean setterBean;

    @Autowired
    public ContructorExampleServiceImpl(FieldBean fieldBean, SetterBean setterBean) {
        this.fieldBean = fieldBean;
        this.setterBean = setterBean;
    }


    @Override
    public String print() {
        return fieldBean.getName() + " - " + setterBean.getValue();
    }
}
