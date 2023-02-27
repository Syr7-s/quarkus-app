package com.syrisa.quarkus.web.graphql.input;

import com.syrisa.quarkus.data.entity.Customer;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.enterprise.context.ApplicationScoped;

@Getter
@Setter
@NoArgsConstructor
@ApplicationScoped
@ToString
public class CustomerInput {

    private String firstName;
    private String lastName;
    private String email;
    private String phone;
    private String address;

    public Customer getEntity(){
        Customer customer = new Customer();
        customer.setFirstName(this.firstName);
        customer.setLastName(this.lastName);
        customer.setEmail(this.email);
        customer.setPhone(this.phone);
        customer.setAddress(this.address);
        return customer;
    }

}
