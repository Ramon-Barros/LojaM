package com.ramon;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class ClienteSpringApplication {

	@GetMapping("/ola")
	public String helloWorld(){
		return "Olá Mundo!!!";
	}
	public static void main(String[] args) {
		SpringApplication.run(ClienteSpringApplication.class, args);
	}

}
