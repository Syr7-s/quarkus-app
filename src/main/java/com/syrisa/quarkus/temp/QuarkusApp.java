package com.syrisa.quarkus.temp;

import com.syrisa.quarkus.data.entity.Service;
import com.syrisa.quarkus.data.repository.CustomerRepository;
import com.syrisa.quarkus.data.repository.ServiceRepository;
import com.syrisa.quarkus.data.repository.VendorRepository;
import io.quarkus.runtime.QuarkusApplication;
import io.quarkus.runtime.annotations.QuarkusMain;
import lombok.RequiredArgsConstructor;

import javax.enterprise.context.control.ActivateRequestContext;

//@QuarkusMain
@RequiredArgsConstructor
public class QuarkusApp implements QuarkusApplication {

    private final ServiceRepository serviceRepository;
    private final CustomerRepository customerRepository;
    private final VendorRepository vendorRepository;

    @Override
    @ActivateRequestContext
    public int run(String... args) throws Exception {
        //serviceRepository.getAllServices().forEach(System.out::println);
        //serviceRepository.listAll().forEach(System.out::println);
        //Service service = serviceRepository.findById(2L);
        //System.out.println(service);
        System.out.println("Customer FindByEmail");
        System.out.println(customerRepository.findByEmail("enim.Mauris.quis@Vivamusnibh.net"));
        System.out.println("Vendor FindByEmail");
        System.out.println(vendorRepository.findByEmail("dbanksa@discovery.com"));
        System.out.println("Vendor FindByName");
        System.out.println(vendorRepository.findByName("Babbleblab"));
        return 0;
    }

}
