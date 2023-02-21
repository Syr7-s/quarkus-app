package com.syrisa.quarkus.data.repository;

import com.syrisa.quarkus.data.entity.Service;
import lombok.RequiredArgsConstructor;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.control.ActivateRequestContext;
import javax.persistence.EntityManager;
import java.util.List;

@ApplicationScoped
@RequiredArgsConstructor
//@ActivateRequestContext
public class ServiceRepository {
    private final EntityManager entityManager;

    public List<Service> getAllServices(){
        List<Service> services = entityManager.createQuery("select service from Service service",Service.class).getResultList();
        return services;
    }
}
