package com.dveritas;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.dveritas")
public class DveritasApplication {

	
	public static void main(String[] args) {
		SpringApplication.run(DveritasApplication.class, args);
		System.out.println("El servidor de Dveritas esta prendido");
	}
	

}
