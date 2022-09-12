package com.deft;

import com.deft.animal.CatConfig;
import com.deft.animal.DogConfig;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import({ DogConfig.class, CatConfig.class })
public class MammalConfiguration {
}
