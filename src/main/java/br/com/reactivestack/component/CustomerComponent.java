package br.com.reactivestack.component;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;
import br.com.reactivestack.repository.*;
import br.com.reactivestack.model.Customer;
import reactor.core.publisher.Flux;

@Component
class CustomerComponent implements ApplicationRunner {
	private final CustomerRepository customerRepository;
	
	public CustomerComponent(CustomerRepository customerRepository) {
		this.customerRepository = customerRepository;
	}
	
	@Override
	public void run(ApplicationArguments args) throws Exception {
		Flux.just("Mia","Hank","Me")
		.flatMap(name -> customerRepository.save(new Customer(null, name)))
		.subscribe(System.out::println);
	}
	
}