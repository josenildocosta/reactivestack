package br.com.reactivestack;

import static org.springframework.web.reactive.function.server.RequestPredicates.GET;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;
import static org.springframework.web.reactive.function.server.ServerResponse.ok;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.userdetails.MapReactiveUserDetailsService;
import org.springframework.security.core.userdetails.User;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import br.com.reactivestack.model.Customer;
import br.com.reactivestack.repository.CustomerRepository;

@SpringBootApplication
public class ReactivestackApplication {

	@Bean
	MapReactiveUserDetailsService users() {
		return new MapReactiveUserDetailsService(User.withDefaultPasswordEncoder().username("user").password("pw").roles("USER").build());
	}

	@Bean
	HealthIndicator healthIndicator() {
		return () -> Health.status("I <3 Production!").build();
	}

	@Bean
	RouterFunction<ServerResponse> routes(CustomerRepository cr) {
		return route(GET("/customers"), serverRequest -> ok().body(cr.findAll(), Customer.class));
	}

	public static void main(String[] args) {
		SpringApplication.run(ReactivestackApplication.class, args);
	}
}