package br.com.reactivestack.repository;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import br.com.reactivestack.model.Customer;

public interface CustomerRepository extends ReactiveMongoRepository<Customer, String> {
}