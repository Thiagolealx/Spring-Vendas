package com.thiago.spring.Spring.Vendas;

import com.thiago.spring.Spring.Vendas.domain.entity.Cliente;
import com.thiago.spring.Spring.Vendas.domain.entity.Pedido;
import com.thiago.spring.Spring.Vendas.domain.repository.ClientesRepository;
import com.thiago.spring.Spring.Vendas.domain.repository.PedidosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;


@SpringBootApplication
public class SpringVendasApplication {

	@Bean
	public CommandLineRunner init (
			@Autowired ClientesRepository clientesRepository,
			@Autowired PedidosRepository pedidosRepository
			){
		return args -> {
			System.out.println("Salvando clientes");
			Cliente fulano = new Cliente("Fulano");
			clientesRepository.save(fulano);

			Pedido p =new Pedido();
			p.setCliente(fulano);
			p.setDataPedido(LocalDate.now());
			p.setTotal(BigDecimal.valueOf(100));

			pedidosRepository.save(p);


	//		Cliente cliente = clientesRepository.findClienteFetchPedidos(fulano.getId());
	//		System.out.println(cliente);
	//		System.out.println(cliente.getPedidos());

			pedidosRepository.findByCliente(fulano).forEach(System.out::println);


		};
	}


	public static void main(String[] args) {

		SpringApplication.run(SpringVendasApplication.class, args);
	}

}
// teste