package br.com.reactivestack.service;

import org.springframework.context.annotation.Bean;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import br.com.reactivestack.model.Customer;
import br.com.reactivestack.repository.CustomerRepository;

import static org.springframework.web.reactive.function.server.RequestPredicates.GET;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;
import static org.springframework.web.reactive.function.server.ServerResponse.ok;

public class CustomerService {
	@Bean
	RouterFunction<ServerResponse> routes(CustomerRepository cr) {
		return route(GET("/customers"), serverRequest -> ok().body(cr.findAll(), Customer.class));
	}
}
