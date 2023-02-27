package com.syrisa.quarkus.service;

import com.syrisa.quarkus.data.entity.Customer;
import com.syrisa.quarkus.data.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;

import javax.enterprise.context.ApplicationScoped;
import javax.transaction.Transactional;
import javax.ws.rs.NotFoundException;
import java.util.ArrayList;
import java.util.List;

@ApplicationScoped
@RequiredArgsConstructor
public class CustomerService {

    private final CustomerRepository customerRepository;

    public List<Customer> getAllCustomers(){
        return this.customerRepository.listAll();
    }
    public List<Customer> getCustomersByEmail(String email){
        Customer customer = this.customerRepository.findByEmail(email);
        List<Customer> customers = new ArrayList<>();
        customers.add(customer);
        return customers;
    }

    @Transactional
    public Customer addCustomer(Customer customer){
        this.customerRepository.persist(customer);
        return customer;
    }

    public Customer getCustomer(long id){
        Customer customer =  this.customerRepository.findById(id);
        if(customer == null){
            throw new NotFoundException();
        }
        return customer;
    }

    @Transactional
    public Customer updateCustomer(Customer customer){
        Customer entity = this.customerRepository.findById(customer.getId());
        if(entity == null){
            throw new NotFoundException();
        }
        entity.setAddress(customer.getAddress());
        entity.setEmail(customer.getEmail());
        entity.setFirstName(customer.getFirstName());
        entity.setPhone(customer.getPhone());
        entity.setLastName(customer.getLastName());
        this.customerRepository.persist(entity);
        return entity;
    }

    @Transactional
    public void deleteCustomer(long id){
        this.customerRepository.deleteById(id);
    }
}
