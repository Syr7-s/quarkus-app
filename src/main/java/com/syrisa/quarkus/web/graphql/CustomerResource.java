package com.syrisa.quarkus.web.graphql;

import com.syrisa.quarkus.data.entity.Customer;
import com.syrisa.quarkus.service.CustomerService;
import com.syrisa.quarkus.web.graphql.input.CustomerInput;
import lombok.RequiredArgsConstructor;
import org.eclipse.microprofile.graphql.*;

import java.util.List;

@GraphQLApi
@RequiredArgsConstructor
public class CustomerResource {
    private final CustomerService customerService;

    @Query("allCustomers")
    @Description("Get all customers available in the system")
    public List<Customer> getCustomers(){
        return customerService.getAllCustomers();
    }

    @Mutation("addCustomer")
    @Description("Adds a Customer to the system")
    public Customer addCustomer(CustomerInput customerInput){
        return this.customerService.addCustomer(customerInput.getEntity());
    }

    @Query("getCustomer")
    @Description("Gets and individual Customer by ID")
    public Customer getCustomer(@Name("id") long id){
        return this.customerService.getCustomer(id);
    }

    @Query("getCustomersByEmail")
    @Description("Gets and individual Customer by email")
    public List<Customer> getCustomerByEmail(@Name("email") String email){
        return customerService.getCustomersByEmail(email);
    }

    @Mutation("updateCustomer")
    @Description("Update an individual Customer")
    public Customer updateCustomer(Customer customer){
        return customerService.updateCustomer(customer);
    }

    @Mutation("deleteCustomer")
    @Description("Delete and individual Customer")
    public Customer deleteCustomer(@Name("id") long id){
        Customer customer = this.customerService.getCustomer(id);
        this.customerService.deleteCustomer(id);
        return customer;
    }
}
