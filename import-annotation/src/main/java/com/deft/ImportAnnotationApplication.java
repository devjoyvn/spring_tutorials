package com.deft;

import com.deft.animal.AnimalScanConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

@SpringBootApplication
@Import(AnimalScanConfiguration.class)
public class ImportAnnotationApplication {

	public static void main(String[] args) {
		SpringApplication.run(ImportAnnotationApplication.class, args);
	}

}
