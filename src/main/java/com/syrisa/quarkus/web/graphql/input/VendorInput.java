package com.syrisa.quarkus.web.graphql.input;

import com.syrisa.quarkus.data.entity.Customer;
import com.syrisa.quarkus.data.entity.Vendor;
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
public class VendorInput {
    private String name;
    private String contact;
    private String phone;
    private String email;
    private String address;

    public Vendor getEntity(){
        Vendor vendor = new Vendor();
        vendor.setName(this.name);
        vendor.setContact(this.contact);
        vendor.setEmail(this.email);
        vendor.setPhone(this.phone);
        vendor.setAddress(this.address);
        return vendor;
    }
}
