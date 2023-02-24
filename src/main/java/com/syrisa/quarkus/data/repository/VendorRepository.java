package com.syrisa.quarkus.data.repository;

import com.syrisa.quarkus.data.entity.Vendor;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import lombok.RequiredArgsConstructor;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
@RequiredArgsConstructor
public class VendorRepository implements PanacheRepository<Vendor> {

    public Vendor findByEmail(String email){
        return find("email",email).firstResult();
    }

    public Vendor findByName(String name){
        return find("lower(name)",name.toLowerCase()).firstResult();
    }
}
