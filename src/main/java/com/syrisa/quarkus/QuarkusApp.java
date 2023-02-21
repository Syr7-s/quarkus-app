package com.syrisa.quarkus;

import com.syrisa.quarkus.data.repository.ServiceRepository;
import io.quarkus.runtime.QuarkusApplication;
import io.quarkus.runtime.annotations.QuarkusMain;
import lombok.RequiredArgsConstructor;

import javax.enterprise.context.control.ActivateRequestContext;

@QuarkusMain
@RequiredArgsConstructor
public class QuarkusApp implements QuarkusApplication {

    private final ServiceRepository serviceRepository;

    @Override
    @ActivateRequestContext
    public int run(String... args) throws Exception {
        serviceRepository.getAllServices().forEach(System.out::println);
        return 0;
    }

}
