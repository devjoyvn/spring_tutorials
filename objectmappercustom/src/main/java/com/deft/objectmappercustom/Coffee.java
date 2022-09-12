package com.deft.objectmappercustom;

import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

@Builder
@Getter
public class Coffee {
    private String name;
    private String brand;
    private LocalDateTime date;
}
