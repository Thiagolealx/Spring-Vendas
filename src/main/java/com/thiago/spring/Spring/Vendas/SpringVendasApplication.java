package com.thiago.spring.Spring.Vendas;

import com.fasterxml.jackson.databind.jsontype.impl.StdTypeResolverBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class SpringVendasApplication {

	@Autowired
	@Qualifier("applicationName")
	private String applicationName;

	@GetMapping("/hello")
	public String helloWord(){
		return applicationName;
	}
	public static void main(String[] args) {
		SpringApplication.run(SpringVendasApplication.class, args);
	}

}
