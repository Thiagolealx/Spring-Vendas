package com.thiago.spring.Spring.Vendas;

import com.thiago.spring.Spring.Vendas.domain.entity.Cliente;
import com.thiago.spring.Spring.Vendas.domain.repository.ClientesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;


@SpringBootApplication
public class SpringVendasApplication {

	public static void main(String[] args) {

		SpringApplication.run(SpringVendasApplication.class, args);
	}

}
