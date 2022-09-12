package com.deft;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Address {

    private @Id
    @GeneratedValue
    Long id;
    private String name;
    private String city;
    private String postalCode;

}

