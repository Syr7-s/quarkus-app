package com.syrisa.quarkus.web.rest;

import com.syrisa.quarkus.data.entity.Customer;
import com.syrisa.quarkus.data.repository.CustomerRepository;
import io.netty.util.internal.StringUtil;
import lombok.RequiredArgsConstructor;
import org.jboss.resteasy.reactive.ResponseStatus;
import org.jboss.resteasy.reactive.RestPath;
import org.jboss.resteasy.reactive.RestQuery;

import javax.transaction.Transactional;
import javax.ws.rs.*;
import java.util.ArrayList;
import java.util.List;

@Path("/rest/customers")
@Produces("application/json")
@Consumes("applications/json")
@RequiredArgsConstructor
public class CustomerEndpoint {
    private final CustomerRepository customerRepository;

    @GET
    public List<Customer> getCustomers(@RestQuery("email") String email){
        if (StringUtil.isNullOrEmpty(email)){
            return this.customerRepository.listAll();
        }
        List<Customer> customers = new ArrayList<>();
        Customer customer = this.customerRepository.findByEmail(email);
        customers.add(customer);
        return customers;
    }

    @POST
    @ResponseStatus(201)
    @Transactional
    public Customer addCustomer(Customer customer){
        this.customerRepository.persist(customer);
        return customer;
    }

    @GET
    @Path("/{id}")
    public Customer getCustomer(@RestPath("id") long id){
        Customer customer = this.customerRepository.findById(id);
        if(customer == null){
            throw new NotFoundException();
        }
        return customer;
    }

    @PUT
    @Path("/{id}")
    @Transactional
    @ResponseStatus(204)
    public void updateCustomer(@RestPath("id") long id,Customer customer){
        if (id != customer.getId()){
            throw new BadRequestException();
        }
        Customer entity = this.customerRepository.findById(id);
        if (entity == null){
            throw new NotFoundException();
        }
        entity.setAddress(customer.getAddress());
        entity.setEmail(customer.getEmail());
        entity.setFirstName(customer.getFirstName());
        entity.setLastName(customer.getLastName());
        entity.setPhone(customer.getPhone());
        this.customerRepository.persist(entity);
    }

    @DELETE
    @Path("/{id}")
    @Transactional
    @ResponseStatus(205)
    public void deleteCustomer(@RestPath("id") long id){
        this.customerRepository.deleteById(id);
    }
}
