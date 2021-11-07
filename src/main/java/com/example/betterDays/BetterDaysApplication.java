package com.example.betterDays;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.convert.threeten.Jsr310JpaConverters;

@EntityScan(     basePackageClasses = { BetterDaysApplication.class, Jsr310JpaConverters.class } )
@SpringBootApplication
public class BetterDaysApplication {

	public static void main(String[] args)throws Exception {
		SpringApplication.run(BetterDaysApplication.class, args);
	}

}
