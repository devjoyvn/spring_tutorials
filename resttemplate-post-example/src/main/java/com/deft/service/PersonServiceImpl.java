package com.deft.service;

import com.deft.model.Person;
import org.springframework.stereotype.Service;

@Service
public class PersonServiceImpl implements PersionService {

    @Override
    public Person save(Person person) {
        return person;
    }

}
