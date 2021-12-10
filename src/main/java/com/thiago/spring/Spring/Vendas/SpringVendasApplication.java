package com.thiago.spring.Spring.Vendas;

import com.thiago.spring.Spring.Vendas.domain.entity.Cliente;
import com.thiago.spring.Spring.Vendas.domain.repository.Clientes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class SpringVendasApplication {

	@Bean
	public CommandLineRunner init (@Autowired Clientes clientes){
		return args -> {
			clientes.salvar(new Cliente("Thiago"));
			clientes.salvar(new Cliente("Outro cliente"));

			List<Cliente> todosClientes = clientes.obterTodos();
			todosClientes.forEach(System.out::println);
		};
	}


	public static void main(String[] args) {
		SpringApplication.run(SpringVendasApplication.class, args);
	}

}
