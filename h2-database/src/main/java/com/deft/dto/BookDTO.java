package com.deft.dto;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
public class BookDTO implements Serializable {

    private Long id;

    private String name;

    private Integer price;

    private String author;
}
