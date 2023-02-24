package com.syrisa.quarkus.data.repository;

import com.syrisa.quarkus.data.entity.Customer;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import lombok.RequiredArgsConstructor;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
@RequiredArgsConstructor
public class CustomerRepository implements PanacheRepository<Customer> {
    public Customer findByEmail(String email){
        return  find("email",email).firstResult();
    }
}
