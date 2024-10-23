package com.encurtador.url;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class EncurtadorApplication {

	public static void main(String[] args) {
		SpringApplication.run(EncurtadorApplication.class, args);
	}

}
